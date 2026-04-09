function getNextBingoNumber(n) {
  const letter = n[0];
  const number = parseInt(n.slice(1));

  const ranges = {
    B: [1, 15, "I"],
    I: [16, 30, "N"],
    N: [31, 45, "G"],
    G: [46, 60, "O"],
    O: [61, 75, "B"]
  };

  const [start, end, nextLetter] = ranges[letter];

  if (number < end) {
    return letter + (number + 1);
  } else {
    const nextStart = ranges[nextLetter][0];
    return nextLetter + nextStart;
  }
}