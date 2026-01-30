function findPawnMoves(position) {
  const col = position[0];
  const row = parseInt(position[1], 10);
  const moves = [];

  // one square forward
  if (row < 8) {
    moves.push(`${col}${row + 1}`);
  }

  // two squares forward if on starting rank
  if (row === 2) {
    moves.push(`${col}${row + 2}`);
  }

  return moves.sort();
}
