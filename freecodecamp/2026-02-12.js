function largestDifference(skater1, skater2) {
  let maxDiff = -Infinity;
  let lapNumber = -1;

  for (let i = 0; i < skater1.length; i++) {
    const diff = Math.abs(skater1[i] - skater2[i]);

    if (diff > maxDiff) {
      maxDiff = diff;
      lapNumber = i + 1; // Lap numbers are 1-based
    }
  }

  return lapNumber;
}
