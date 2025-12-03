/**
 * Checks if a number consists of repeated characters (doubled pattern)
 * Example: "123123" -> true, "1234" -> false
 */
function isRepeatedCharacters(num: number): boolean {
  const str = num.toString();
  const length = str.length;
  
  // Must be even length to split in half
  if (length % 2 !== 0) {
    return false;
  }
  
  const halfLength = length / 2;
  const leftHalf = str.substring(0, halfLength);
  const rightHalf = str.substring(halfLength);
  
  return leftHalf === rightHalf;
}

/**
 * Checks if a product ID is invalid (Part 1 rules)
 * An ID is invalid if it's made of repeated characters (exactly twice)
 */
function isInvalid(productId: number): boolean {
  return isRepeatedCharacters(productId);
}

/**
 * Checks if a number consists of a pattern repeated at least twice
 * Example: "123123" (2 times), "123123123" (3 times), "1111" (4 times of "1")
 */
function isRepeatedAtLeastTwice(num: number): boolean {
  const str = num.toString();
  const length = str.length;
  
  // Try all possible pattern lengths (from 1 to length/2)
  for (let patternLength = 1; patternLength <= length / 2; patternLength++) {
    // Check if the string length is divisible by pattern length
    if (length % patternLength === 0) {
      const pattern = str.substring(0, patternLength);
      const repetitions = length / patternLength;
      
      // Must be repeated at least twice
      if (repetitions >= 2) {
        // Check if the entire string is this pattern repeated
        let isMatch = true;
        for (let i = 0; i < repetitions; i++) {
          const segment = str.substring(i * patternLength, (i + 1) * patternLength);
          if (segment !== pattern) {
            isMatch = false;
            break;
          }
        }
        
        if (isMatch) {
          return true;
        }
      }
    }
  }
  
  return false;
}

/**
 * Checks if a product ID is invalid (Part 2 rules)
 * An ID is invalid if it's made of a pattern repeated at least twice
 */
function isInvalidPart2(productId: number): boolean {
  return isRepeatedAtLeastTwice(productId);
}

/**
 * Solves Part 1: finds all invalid IDs (doubled patterns) and returns their sum
 */
function solvePart1(input: string): number {
  let totalSum = 0;
  
  const ranges = input.trim().split(',');
  
  for (const range of ranges) {
    const trimmedRange = range.trim();
    if (!trimmedRange) continue;
    
    const [startStr, endStr] = trimmedRange.split('-');
    const start = parseInt(startStr);
    const end = parseInt(endStr);
    
    for (let num = start; num <= end; num++) {
      if (isInvalid(num)) {
        totalSum += num;
      }
    }
  }
  
  return totalSum;
}

/**
 * Solves Part 2: finds all invalid IDs (patterns repeated at least twice) and returns their sum
 */
function solvePart2(input: string): number {
  let totalSum = 0;
  
  const ranges = input.trim().split(',');
  
  for (const range of ranges) {
    const trimmedRange = range.trim();
    if (!trimmedRange) continue;
    
    const [startStr, endStr] = trimmedRange.split('-');
    const start = parseInt(startStr);
    const end = parseInt(endStr);
    
    for (let num = start; num <= end; num++) {
      if (isInvalidPart2(num)) {
        totalSum += num;
      }
    }
  }
  
  return totalSum;
}



// Example usage:
const input = `11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124`;

console.log("Part 1:", solvePart1(input));  // 1227775554
console.log("Part 2:", solvePart2(input));  // 4174379265
