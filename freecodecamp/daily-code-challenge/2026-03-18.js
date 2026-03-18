function largestNumber(str) {
  let nums = str.split(/[,:;!?]/).map(Number);
  return Math.max(...nums);
}