/**
 * Parses the input into fresh ranges and available IDs
 */
function parseInput(input: string): { ranges: Array<[number, number]>, availableIds: number[] } {
  const sections = input.trim().split('\n\n');
  
  // Parse fresh ranges
  const rangeLines = sections[0].split('\n');
  const ranges: Array<[number, number]> = [];
  
  for (const line of rangeLines) {
    const [start, end] = line.trim().split('-').map(Number);
    ranges.push([start, end]);
  }
  
  // Parse available IDs
  const idLines = sections[1].split('\n');
  const availableIds: number[] = [];
  
  for (const line of idLines) {
    const id = parseInt(line.trim());
    availableIds.push(id);
  }
  
  return { ranges, availableIds };
}

/**
 * Checks if an ingredient ID is fresh (falls within any range)
 */
function isFresh(id: number, ranges: Array<[number, number]>): boolean {
  for (const [start, end] of ranges) {
    if (id >= start && id <= end) {
      return true;
    }
  }
  return false;
}

/**
 * Solves Part 1: Count how many available ingredient IDs are fresh
 */
function solvePart1(input: string): number {
  const { ranges, availableIds } = parseInput(input);
  let freshCount = 0;
  
  for (const id of availableIds) {
    if (isFresh(id, ranges)) {
      freshCount++;
    }
  }
  
  return freshCount;
}

/**
 * Merges overlapping ranges into non-overlapping ranges
 */
function mergeRanges(ranges: Array<[number, number]>): Array<[number, number]> {
  if (ranges.length === 0) return [];
  
  // Sort ranges by start position
  const sorted = [...ranges].sort((a, b) => a[0] - b[0]);
  const merged: Array<[number, number]> = [sorted[0]];
  
  for (let i = 1; i < sorted.length; i++) {
    const [currentStart, currentEnd] = sorted[i];
    const lastMerged = merged[merged.length - 1];
    
    // Check if current range overlaps or is adjacent to the last merged range
    if (currentStart <= lastMerged[1] + 1) {
      // Merge by extending the end of the last merged range
      lastMerged[1] = Math.max(lastMerged[1], currentEnd);
    } else {
      // No overlap, add as new range
      merged.push([currentStart, currentEnd]);
    }
  }
  
  return merged;
}

/**
 * Counts total unique IDs covered by all ranges (optimized for large ranges)
 */
function countTotalFreshIds(ranges: Array<[number, number]>): number {
  const merged = mergeRanges(ranges);
  let total = 0;
  
  // Don't iterate through individual IDs, just calculate the count
  for (const [start, end] of merged) {
    total += (end - start + 1);
  }
  
  return total;
}

/**
 * Solves Part 2: Count total ingredient IDs considered fresh by the ranges
 */
function solvePart2(input: string): number {
  const { ranges } = parseInput(input);
  return countTotalFreshIds(ranges);
}

const exampleInput = `3-5
10-14
16-20
12-18

1
5
8
11
17
32`

console.log("Part 1:", solvePart1(exampleInput)); // Should output: 3
console.log("Part 2:", solvePart2(exampleInput)); // Should output: 14

