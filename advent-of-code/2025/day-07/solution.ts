/**
 * Represents a tachyon beam with position
 */
interface Beam {
  row: number;
  col: number;
}

/**
 * Simulates the tachyon beam through the manifold (Part 1)
 */
function simulateBeam(grid: string[]): number {
  const rows = grid.length;
  const cols = grid[0].length;
  
  // Find the starting position (S)
  let startCol = -1;
  for (let col = 0; col < cols; col++) {
    if (grid[0][col] === 'S') {
      startCol = col;
      break;
    }
  }
  
  if (startCol === -1) return 0;
  
  // Track which splitters have been hit already
  const hitSplitters = new Set<string>();
  
  // Track active beam positions (use Set to avoid duplicates at same position)
  let currentBeams = new Set<string>();
  currentBeams.add(`1,${startCol}`);
  
  let splitCount = 0;
  
  // Keep processing until no more beams
  while (currentBeams.size > 0) {
    const nextBeams = new Set<string>();
    
    for (const beamKey of currentBeams) {
      const [rowStr, colStr] = beamKey.split(',');
      const row = parseInt(rowStr);
      const col = parseInt(colStr);
      
      // Check if beam is out of bounds
      if (row < 0 || row >= rows || col < 0 || col >= cols) {
        continue;
      }
      
      const cell = grid[row][col];
      
      if (cell === '^') {
        const splitterKey = `${row},${col}`;
        
        // Only count this splitter if we haven't hit it before
        if (!hitSplitters.has(splitterKey)) {
          hitSplitters.add(splitterKey);
          splitCount++;
        }
        
        // Create left and right beams
        if (col - 1 >= 0 && row + 1 < rows) {
          nextBeams.add(`${row + 1},${col - 1}`);
        }
        if (col + 1 < cols && row + 1 < rows) {
          nextBeams.add(`${row + 1},${col + 1}`);
        }
      } else {
        // Empty space or S - continue downward
        if (row + 1 < rows) {
          nextBeams.add(`${row + 1},${col}`);
        }
      }
    }
    
    currentBeams = nextBeams;
  }
  
  return splitCount;
}

/**
 * Solves Part 1: Count how many times the beam is split
 */
function solvePart1(input: string): number {
  const grid = input.trim().split('\n').map(line => line.replace(/\s+$/, ''));
  return simulateBeam(grid);
}

/**
 * Counts unique timelines using DFS with memoization (Part 2)
 */
function countTimelines(grid: string[], row: number, col: number, memo: Map<string, number>): number {
  const rows = grid.length;
  const cols = grid[0].length;
  
  // Out of bounds - this is one complete timeline
  if (row >= rows || col < 0 || col >= cols) {
    return 1;
  }
  
  // Check memoization
  const key = `${row},${col}`;
  if (memo.has(key)) {
    return memo.get(key)!;
  }
  
  const cell = grid[row][col];
  let timelineCount = 0;
  
  if (cell === '^') {
    // At a splitter, count timelines from both branches
    const leftTimelines = countTimelines(grid, row + 1, col - 1, memo);
    const rightTimelines = countTimelines(grid, row + 1, col + 1, memo);
    timelineCount = leftTimelines + rightTimelines;
  } else {
    // Empty space - continue downward
    timelineCount = countTimelines(grid, row + 1, col, memo);
  }
  
  memo.set(key, timelineCount);
  return timelineCount;
}

/**
 * Simulates quantum tachyon particle through the manifold (Part 2)
 */
function simulateQuantumBeam(grid: string[]): number {
  const rows = grid.length;
  const cols = grid[0].length;
  
  // Find the starting position (S)
  let startCol = -1;
  for (let col = 0; col < cols; col++) {
    if (grid[0][col] === 'S') {
      startCol = col;
      break;
    }
  }
  
  if (startCol === -1) return 0;
  
  // Use memoization to avoid recalculating paths
  const memo = new Map<string, number>();
  
  // Start from row 1 (below S)
  return countTimelines(grid, 1, startCol, memo);
}

/**
 * Solves Part 2: Count the number of different timelines
 */
function solvePart2(input: string): number {
  const grid = input.trim().split('\n').map(line => line.replace(/\s+$/, ''));
  return simulateQuantumBeam(grid);
}

// Example usage:
const exampleInput = `.......S.......
...............
.......^.......
...............
......^.^......
...............
.....^.^.^.....
...............
....^.^...^....
...............
...^.^...^.^...
...............
..^...^.....^..
...............
.^.^.^.^.^...^.
...............`;

console.log("Part 1:", solvePart1(exampleInput)); // Should output: 21
console.log("Part 2:", solvePart2(exampleInput)); // Should output: 40
