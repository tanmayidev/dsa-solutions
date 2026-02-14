function getDifficulty(track) {
  let score = 0;
  
  for (let i = 0; i < track.length; i++) {
    if (track[i] === "L" || track[i] === "R") {
      if (
        i > 0 &&
        ((track[i] === "L" && track[i - 1] === "R") ||
         (track[i] === "R" && track[i - 1] === "L"))
      ) {
        score += 15;
      } else {
        score += 5;
      }
    }
  }
  
  if (score <= 100) return "Easy";
  if (score <= 200) return "Medium";
  return "Hard";
}
