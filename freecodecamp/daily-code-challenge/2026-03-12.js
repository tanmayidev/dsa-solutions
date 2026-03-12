function isValidDominoChain(dominoes) {
  for (let i = 0; i < dominoes.length - 1; i++) {
    if (dominoes[i][1] !== dominoes[i + 1][0]) {
      return false;
    }
  }
  return true;
}
