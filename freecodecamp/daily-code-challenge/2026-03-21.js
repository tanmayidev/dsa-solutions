function rotate(mat) {
  let res = Array.from({ length: 6 }, () => Array(6));
  for (let i = 0; i < 6; i++) {
    for (let j = 0; j < 6; j++) {
      res[j][5 - i] = mat[i][j];
    }
  }
  return res.map(row => row.join(''));
}

function isValid(mat) {
  function check(r, c) {
    return mat[r][c] === '1' && mat[r][c+1] === '1' &&
           mat[r+1][c] === '1' && mat[r+1][c+1] === '1';
  }
  return check(0,0) && check(0,4) && check(4,0);
}

function decodeQr(qrCode) {
  let mat = qrCode;

  for (let k = 0; k < 4; k++) {
    if (isValid(mat)) break;
    mat = rotate(mat);
  }

  let result = [];

  for (let i = 0; i < 6; i++) {
    for (let j = 0; j < 6; j++) {
      if ((i < 2 && j < 2) || (i < 2 && j >= 4) || (i >= 4 && j < 2)) continue;
      result.push(mat[i][j]);
    }
  }

  return result.join('');
}
