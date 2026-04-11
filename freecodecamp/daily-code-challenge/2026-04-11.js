function rookBishopAttack(rook, bishop) {
  // Convert column letters to numbers (A → 0, B → 1, ..., H → 7)
  const col1 = rook.charCodeAt(0) - 'A'.charCodeAt(0);
  const row1 = parseInt(rook[1]);

  const col2 = bishop.charCodeAt(0) - 'A'.charCodeAt(0);
  const row2 = parseInt(bishop[1]);

  // Rook attack (same row or column)
  if (col1 === col2 || row1 === row2) {
    return "rook";
  }

  // Bishop attack (diagonal)
  if (Math.abs(col1 - col2) === Math.abs(row1 - row2)) {
    return "bishop";
  }

  return "neither";
}