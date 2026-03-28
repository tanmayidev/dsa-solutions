function pascalRow(n) {
  if (n <= 0) return [];

  const row = [1];
  let prev = 1;

  for (let k = 1; k < n; k++) {
    const curr = (prev * (n - k)) / k;
    row.push(curr);
    prev = curr;
  }

  return row;
}