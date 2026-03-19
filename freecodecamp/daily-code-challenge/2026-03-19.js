function invertMatrix(matrix) {
  // Get the two unique values
  const values = new Set();
  for (let row of matrix) {
    for (let val of row) {
      values.add(val);
    }
  }

  const [a, b] = [...values];

  // Create new matrix with swapped values
  return matrix.map(row =>
    row.map(val => (val === a ? b : a))
  );
}
