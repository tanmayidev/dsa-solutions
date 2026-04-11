function rookAttack(rook1, rook2) {
  const col1 = rook1[0];
  const row1 = rook1[1];

  const col2 = rook2[0];
  const row2 = rook2[1];

  return col1 === col2 || row1 === row2;
}