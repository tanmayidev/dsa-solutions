function scoreCurling(house) {
  const center = [2, 2];
  
  function ringDistance(r, c) {
    return Math.max(Math.abs(r - center[0]), Math.abs(c - center[1]));
  }
  
  const stones = { R: [], Y: [] };
  
  for (let r = 0; r < 5; r++) {
    for (let c = 0; c < 5; c++) {
      if (house[r][c] === "R" || house[r][c] === "Y") {
        stones[house[r][c]].push(ringDistance(r, c));
      }
    }
  }
  
  if (stones.R.length === 0 && stones.Y.length === 0) {
    return "No points awarded";
  }
  
  let scoringTeam;
  
  if (stones.R.length === 0) {
    scoringTeam = "Y";
  } else if (stones.Y.length === 0) {
    scoringTeam = "R";
  } else {
    const minR = Math.min(...stones.R);
    const minY = Math.min(...stones.Y);
    
    if (minR === minY) {
      return "No points awarded";
    }
    
    scoringTeam = minR < minY ? "R" : "Y";
  }
  
  const opponent = scoringTeam === "R" ? "Y" : "R";
  const opponentMin = stones[opponent].length > 0
    ? Math.min(...stones[opponent])
    : Infinity;
  
  const points = stones[scoringTeam].filter(d => d < opponentMin).length;
  
  return `${scoringTeam}: ${points}`;
}
