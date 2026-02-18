function calculateStartDelays(jumpScores) {
  const bestScore = Math.max(...jumpScores);
  
  return jumpScores.map(score => {
    const delay = (bestScore - score) * 1.5;
    return Math.ceil(delay);
  });
}
