/**
 * Parses the worksheet into individual problems by identifying columns (Part 1 - Left-to-Right)
 */
function parseWorksheet(input: string): Array<{ numbers: number[], operation: string }> {
  const lines = input.split('\n');
  const operationLine = lines[lines.length - 1];
  const numberLines = lines.slice(0, -1);
  
  // Find columns that are completely empty (separators)
  const maxLength = Math.max(...lines.map(l => l.length));
  const isEmptyColumn: boolean[] = new Array(maxLength).fill(true);
  
  // Check each column to see if it's empty across ALL lines
  for (let col = 0; col < maxLength; col++) {
    for (const line of lines) {
      if (col < line.length && line[col] !== ' ') {
        isEmptyColumn[col] = false;
        break;
      }
    }
  }
  
  // Find the ranges of non-empty columns (these are our problems)
  const problemRanges: Array<[number, number]> = [];
  let start = -1;
  
  for (let col = 0; col <= maxLength; col++) {
    if (col < maxLength && !isEmptyColumn[col]) {
      // Start of a problem or continuation
      if (start === -1) {
        start = col;
      }
    } else {
      // Empty column or end of line
      if (start !== -1) {
        problemRanges.push([start, col - 1]);
        start = -1;
      }
    }
  }
  
  // Extract problems from each range (left-to-right)
  const problems: Array<{ numbers: number[], operation: string }> = [];
  
  for (const [startCol, endCol] of problemRanges) {
    // Get the operation from this range
    let operation = '';
    for (let col = startCol; col <= endCol; col++) {
      if (col < operationLine.length && operationLine[col] !== ' ') {
        operation = operationLine[col];
        break;
      }
    }
    
    if (!operation) continue;
    
    // Extract all numbers from this range
    const numbers: number[] = [];
    for (const line of numberLines) {
      const segment = line.substring(startCol, endCol + 1).trim();
      if (segment !== '') {
        numbers.push(parseInt(segment));
      }
    }
    
    if (numbers.length > 0) {
      problems.push({ numbers, operation });
    }
  }
  
  return problems;
}

/**
 * Solves a single math problem
 */
function solveProblem(numbers: number[], operation: string): number {
  if (numbers.length === 0) return 0;
  
  let result = numbers[0];
  
  for (let i = 1; i < numbers.length; i++) {
    if (operation === '+') {
      result += numbers[i];
    } else if (operation === '*') {
      result *= numbers[i];
    }
  }
  
  return result;
}

/**
 * Solves Part 1: Calculate the grand total of all problems (left-to-right reading)
 */
function solvePart1(input: string): number {
  const problems = parseWorksheet(input);
  let grandTotal = 0;
  
  for (const problem of problems) {
    const answer = solveProblem(problem.numbers, problem.operation);
    grandTotal += answer;
  }
  
  return grandTotal;
}

/**
 * Parses the worksheet reading right-to-left, column by column (Part 2 - Cephalopod style)
 */
function parseWorksheetRightToLeft(input: string): Array<{ numbers: number[], operation: string }> {
  const lines = input.split('\n');
  const operationLine = lines[lines.length - 1];
  const numberLines = lines.slice(0, -1);
  
  // Find columns that are completely empty (separators)
  const maxLength = Math.max(...lines.map(l => l.length));
  const isEmptyColumn: boolean[] = new Array(maxLength).fill(true);
  
  // Check each column to see if it's empty across ALL lines
  for (let col = 0; col < maxLength; col++) {
    for (const line of lines) {
      if (col < line.length && line[col] !== ' ') {
        isEmptyColumn[col] = false;
        break;
      }
    }
  }
  
  // Find the ranges of non-empty columns (these are our problems)
  const problemRanges: Array<[number, number]> = [];
  let start = -1;
  
  for (let col = 0; col <= maxLength; col++) {
    if (col < maxLength && !isEmptyColumn[col]) {
      if (start === -1) {
        start = col;
      }
    } else {
      if (start !== -1) {
        problemRanges.push([start, col - 1]);
        start = -1;
      }
    }
  }
  
  // Extract problems from each range (right-to-left, column by column)
  const problems: Array<{ numbers: number[], operation: string }> = [];
  
  for (const [startCol, endCol] of problemRanges) {
    // Get the operation from this range
    let operation = '';
    for (let col = startCol; col <= endCol; col++) {
      if (col < operationLine.length && operationLine[col] !== ' ') {
        operation = operationLine[col];
        break;
      }
    }
    
    if (!operation) continue;
    
    // Read right-to-left, column by column
    const numbers: number[] = [];
    
    // Process each column from right to left
    for (let col = endCol; col >= startCol; col--) {
      // Build number from top to bottom in this column
      let digitString = '';
      for (const line of numberLines) {
        if (col < line.length && line[col] !== ' ') {
          digitString += line[col];
        }
      }
      
      if (digitString !== '') {
        numbers.push(parseInt(digitString));
      }
    }
    
    if (numbers.length > 0) {
      problems.push({ numbers, operation });
    }
  }
  
  return problems;
}

/**
 * Solves Part 2: Calculate the grand total reading right-to-left (Cephalopod style)
 */
function solvePart2(input: string): number {
  const problems = parseWorksheetRightToLeft(input);
  let grandTotal = 0;
  
  for (const problem of problems) {
    const answer = solveProblem(problem.numbers, problem.operation);
    grandTotal += answer;
  }
  
  return grandTotal;
}

// Example usage:
const exampleInput = `123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  `;

console.log("Part 1:", solvePart1(exampleInput)); // Should output: 4277556
console.log("Part 2:", solvePart2(exampleInput)); // Should output: 3263827

// // Detailed breakdown for Part 1
// function detailedAnalysisPart1(input: string): void {
//   const problems = parseWorksheet(input);
  
//   console.log("\nPart 1 Detailed Analysis:");
//   problems.forEach((problem, idx) => {
//     const answer = solveProblem(problem.numbers, problem.operation);
//     console.log(`Problem ${idx + 1}: ${problem.numbers.join(` ${problem.operation} `)} = ${answer}`);
//   });
// }

// // Detailed breakdown for Part 2
// function detailedAnalysisPart2(input: string): void {
//   const problems = parseWorksheetRightToLeft(input);
  
//   console.log("\nPart 2 Detailed Analysis (Right-to-Left):");
//   problems.forEach((problem, idx) => {
//     const answer = solveProblem(problem.numbers, problem.operation);
//     console.log(`Problem ${idx + 1}: ${problem.numbers.join(` ${problem.operation} `)} = ${answer}`);
//   });
// }

// detailedAnalysisPart1(exampleInput);
// detailedAnalysisPart2(exampleInput);
