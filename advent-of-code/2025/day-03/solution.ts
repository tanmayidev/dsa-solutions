/**
 * Finds the maximum joltage possible from a single battery bank
 * by selecting exactly two batteries
 */
function findMaxJoltage(bank: string): number {
  const digits = bank.trim();
  let maxJoltage = 0;
  
  // Try all possible pairs of batteries (i, j) where i < j
  for (let i = 0; i < digits.length; i++) {
    for (let j = i + 1; j < digits.length; j++) {
      // Form the two-digit number using batteries at positions i and j
      const joltage = parseInt(digits[i] + digits[j]);
      maxJoltage = Math.max(maxJoltage, joltage);
    }
  }
  
  return maxJoltage;
}

/**
 * Finds the maximum joltage possible from a single battery bank
 * by selecting exactly twelve batteries
 */
function findMaxJoltageTwelve(bank: string): number {
  const digits = bank.trim();
  const n = digits.length;
  const selectCount = 12;
  
  // We need to select 12 digits that form the maximum number
  // Use greedy approach: for each position in result, pick the largest digit
  // such that we still have enough digits remaining
  
  let result = '';
  let currentIndex = 0;
  
  for (let position = 0; position < selectCount; position++) {
    // How many more digits do we need after this one?
    const remaining = selectCount - position - 1;
    
    // We can search up to index (n - remaining - 1)
    const searchEnd = n - remaining;
    
    // Find the largest digit in the searchable range
    let maxDigit = digits[currentIndex];
    let maxIndex = currentIndex;
    
    for (let i = currentIndex; i < searchEnd; i++) {
      if (digits[i] > maxDigit) {
        maxDigit = digits[i];
        maxIndex = i;
      }
    }
    
    result += maxDigit;
    currentIndex = maxIndex + 1;
  }
  
  return parseInt(result);
}

/**
 * Solves Part 1: Find the total output joltage from all battery banks
 * (selecting exactly 2 batteries per bank)
 */
function solvePart1(input: string): number {
  let totalJoltage = 0;
  
  const banks = input.trim().split('\n');
  
  for (const bank of banks) {
    const trimmedBank = bank.trim();
    if (!trimmedBank) continue;
    
    const maxJoltage = findMaxJoltage(trimmedBank);
    totalJoltage += maxJoltage;
  }
  
  return totalJoltage;
}

/**
 * Solves Part 2: Find the total output joltage from all battery banks
 * (selecting exactly 12 batteries per bank)
 */
function solvePart2(input: string): number {
  let totalJoltage = 0;
  
  const banks = input.trim().split('\n');
  
  for (const bank of banks) {
    const trimmedBank = bank.trim();
    if (!trimmedBank) continue;
    
    const maxJoltage = findMaxJoltageTwelve(trimmedBank);
    totalJoltage += maxJoltage;
  }
  
  return totalJoltage;
}

// Example usage:
const exampleInput = `987654321111111
811111111111119
234234234234278
818181911112111`;

console.log("Part 1:", solvePart1(exampleInput)); // Should output: 357
console.log("Part 2:", solvePart2(exampleInput)); // Should output: 3121910778619
