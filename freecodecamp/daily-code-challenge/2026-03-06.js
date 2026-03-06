function navigateTrail(map) {
  const rows = map.length;
  const cols = map[0].length;

  const grid = map.map(r => r.split(""));

  let start;

  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      if (grid[r][c] === "C") start = [r, c];
    }
  }

  const dirs = [
    [0, 1, "R"],
    [1, 0, "D"],
    [0, -1, "L"],
    [-1, 0, "U"]
  ];

  let [r, c] = start;
  let prev = null;
  let result = "";

  while (grid[r][c] !== "G") {
    for (let [dr, dc, move] of dirs) {
      let nr = r + dr;
      let nc = c + dc;

      if (
        nr >= 0 && nr < rows &&
        nc >= 0 && nc < cols &&
        (grid[nr][nc] === "T" || grid[nr][nc] === "G") &&
        (!prev || nr !== prev[0] || nc !== prev[1])
      ) {
        prev = [r, c];
        r = nr;
        c = nc;
        result += move;
        break;
      }
    }
  }

  return result;
}
