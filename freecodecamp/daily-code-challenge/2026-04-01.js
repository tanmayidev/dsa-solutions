function fixPrankNumber(arr) {
  const n = arr.length;

  // Step 1: get differences
  let diffs = [];
  for (let i = 1; i < n; i++) {
    diffs.push(arr[i] - arr[i - 1]);
  }

  // Step 2: most common difference
  let freq = {};
  for (let d of diffs) {
    freq[d] = (freq[d] || 0) + 1;
  }

  let correctDiff = Number(Object.keys(freq).reduce((a, b) =>
    freq[a] > freq[b] ? a : b
  ));

  // Step 3: try different starting points
  let best = null;

  for (let startIdx = 0; startIdx < Math.min(3, n); startIdx++) {
    let startVal = arr[startIdx] - startIdx * correctDiff;

    let candidate = [];
    for (let i = 0; i < n; i++) {
      candidate.push(startVal + i * correctDiff);
    }

    // count differences
    let changes = 0;
    for (let i = 0; i < n; i++) {
      if (candidate[i] !== arr[i]) changes++;
    }

    if (changes <= 1) return candidate;
  }

  return arr;
}