function findDifferences(arr) {
  const result = [];
  
  for (let i = 0; i < arr.length - 1; i++) {
    result.push(arr[i + 1] - arr[i]);
  }
  
  result.push(0); // last element
  
  return result;
}
