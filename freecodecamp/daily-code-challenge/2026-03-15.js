function getCapturedValue(pieces) {

  const start = { P:8, R:2, N:2, B:2, Q:1, K:1 };
  const values = { P:1, R:5, N:3, B:3, Q:9, K:0 };

  const count = { P:0, R:0, N:0, B:0, Q:0, K:0 };

  for (let p of pieces) {
    count[p]++;
  }

  if (count["K"] === 0) return "Checkmate";

  let total = 0;

  for (let p in start) {
    let captured = start[p] - count[p];
    total += captured * values[p];
  }

  return total;
}
