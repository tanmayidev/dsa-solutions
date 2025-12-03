/**
 * Counts how many times the dial crosses through 0 during a rotation
 */
function countZeroCrossings(startPos: number, distance: number, direction: 'L' | 'R'): number {
  if (distance === 0) return 0;
  
  // Count complete loops (every 100 steps crosses 0)
  const completeLoops = Math.floor(distance / 100);
  let crossings = completeLoops;
  
  // Work with remaining steps after complete loops
  const remainingSteps = distance % 100;
  
  if (direction === 'L') {
    // Moving left (decreasing)
    let at = startPos;
    if (at === 0) {
      at = 100;
    }
    
    if (at <= remainingSteps) {
      // We cross 0 in the remaining rotation
      crossings++;
    }
  } else {
    // Moving right (increasing)
    if (startPos + remainingSteps >= 100) {
      // We cross 0 in the remaining rotation
      crossings++;
    }
  }
  
  return crossings;
}

/**
 * Calculates the final position after a rotation
 */
function calculateFinalPosition(startPos: number, distance: number, direction: 'L' | 'R'): number {
  const remainingSteps = distance % 100;
  
  if (direction === 'L') {
    let at = startPos;
    if (at === 0) {
      at = 100;
    }
    
    if (at <= remainingSteps) {
      at += (100 - remainingSteps);
      at %= 100;
    } else {
      at -= remainingSteps;
    }
    return at;
  } else {
    // Moving right
    return (startPos + remainingSteps) % 100;
  }
}

/**
 * Solves Part 1: Count how many times the dial ends at position 0
 */
function solvePart1(input: string): number {
  let position = 50;
  let zeroCount = 0;
  
  const lines = input.trim().split('\n');
  
  for (const line of lines) {
    const trimmedLine = line.trim();
    if (!trimmedLine) continue;
    
    const direction = trimmedLine[0] as 'L' | 'R';
    const distance = parseInt(trimmedLine.substring(1));
    
    // Calculate final position
    position = calculateFinalPosition(position, distance, direction);
    
    // Check if we ended at 0
    if (position === 0) {
      zeroCount++;
    }
  }
  
  return zeroCount;
}

/**
 * Solves Part 2: Count all times the dial points at 0 (during and at end of rotations)
 */
function solvePart2(input: string): number {
  let position = 50;
  let zeroCount = 0;
  
  const lines = input.trim().split('\n');
  
  for (const line of lines) {
    const trimmedLine = line.trim();
    if (!trimmedLine) continue;
    
    const direction = trimmedLine[0] as 'L' | 'R';
    const distance = parseInt(trimmedLine.substring(1));
    
    // Count crossings during rotation
    const crossings = countZeroCrossings(position, distance, direction);
    zeroCount += crossings;
    
    // Calculate final position
    position = calculateFinalPosition(position, distance, direction);
  }
  
  return zeroCount;
}

// Example usage:
const exampleInput = `L68
L30
R48
L5
R60
L55
L1
L99
R14
L82`;

console.log("Part 1:", solvePart1(exampleInput)); // Should output: 3
console.log("Part 2:", solvePart2(exampleInput)); // Should output: 6
