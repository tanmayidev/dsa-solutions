/**
 * Counts the number of paper rolls (@) in the 8 adjacent positions
 */
function countAdjacentRolls(grid: string[], row: number, col: number): number {
  const rows = grid.length;
  const cols = grid[0].length;
  let count = 0;
  
  // Check all 8 adjacent positions
  const directions = [
    [-1, -1], [-1, 0], [-1, 1],  // top-left, top, top-right
    [0, -1],           [0, 1],    // left, right
    [1, -1],  [1, 0],  [1, 1]     // bottom-left, bottom, bottom-right
  ];
  
  for (const [dr, dc] of directions) {
    const newRow = row + dr;
    const newCol = col + dc;
    
    // Check if position is within bounds
    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
      if (grid[newRow][newCol] === '@') {
        count++;
      }
    }
  }
  
  return count;
}

/**
 * Checks if a paper roll at the given position can be accessed by a forklift
 */
function canAccess(grid: string[], row: number, col: number): boolean {
  // Must be a paper roll
  if (grid[row][col] !== '@') {
    return false;
  }
  
  // Can access if fewer than 4 adjacent rolls
  const adjacentCount = countAdjacentRolls(grid, row, col);
  return adjacentCount < 4;
}

/**
 * Solves Part 1: Count how many paper rolls can be accessed by a forklift
 */
function solvePart1(input: string): number {
  const grid = input.trim().split('\n').map(line => line.trim());
  let accessibleCount = 0;
  
  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[row].length; col++) {
      if (canAccess(grid, row, col)) {
        accessibleCount++;
      }
    }
  }
  
  return accessibleCount;
}

/**
 * Finds all accessible paper rolls in the current grid state
 */
function findAccessibleRolls(grid: string[][]): Array<[number, number]> {
  const accessible: Array<[number, number]> = [];
  
  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[row].length; col++) {
      if (canAccess(grid, row, col)) {
        accessible.push([row, col]);
      }
    }
  }
  
  return accessible;
}

/**
 * Removes accessible paper rolls from the grid
 */
function removeRolls(grid: string[][], positions: Array<[number, number]>): void {
  for (const [row, col] of positions) {
    grid[row][col] = '.';
  }
}

/**
 * Solves Part 2: Count total rolls that can be removed by repeating the process
 */
function solvePart2(input: string): number {
  // Create a mutable 2D grid
  const grid = input.trim().split('\n').map(line => line.trim().split(''));
  let totalRemoved = 0;
  
  while (true) {
    // Find all accessible rolls in current state
    const accessible = findAccessibleRolls(grid);
    
    // If no more accessible rolls, stop
    if (accessible.length === 0) {
      break;
    }
    
    // Remove the accessible rolls
    removeRolls(grid, accessible);
    totalRemoved += accessible.length;
  }
  
  return totalRemoved;
}


//Example usage:
const exampleInput = `..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.`;


console.log("Part 1:", solvePart1(exampleInput)); // Should output: 13
console.log("Part 2:", solvePart2(exampleInput)); // Should output: 43

// Visual representation for debugging
// function visualize(input: string): void {
//   const grid = input.trim().split('\n').map(line => line.trim());
//   let result = '';
  
//   for (let row = 0; row < grid.length; row++) {
//     for (let col = 0; col < grid[row].length; col++) {
//       if (canAccess(grid, row, col)) {
//         result += 'x';
//       } else {
//         result += grid[row][col];
//       }
//     }
//     result += '\n';
//   }
  
//   console.log("Visualization:");
//   console.log(result);
// }

// visualize(exampleInput);
