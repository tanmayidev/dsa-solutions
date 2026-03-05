function smallestGap(str) {
  let lastSeen = {};
  let minGap = Infinity;
  let result = "";

  for (let i = 0; i < str.length; i++) {
    let char = str[i];

    if (char in lastSeen) {
      let gap = i - lastSeen[char] - 1;

      if (gap < minGap) {
        minGap = gap;
        result = str.slice(lastSeen[char] + 1, i);
      }
    }

    lastSeen[char] = i;
  }

  return result;
}
