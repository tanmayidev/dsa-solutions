function computeScore(judgeScores, ...penalties) {
  // Sort scores
  const sorted = [...judgeScores].sort((a, b) => a - b);
  
  // Remove lowest and highest
  const baseScore = sorted.slice(1, -1)
                          .reduce((sum, score) => sum + score, 0);
  
  // Sum penalties
  const totalPenalty = penalties.reduce((sum, p) => sum + p, 0);
  
  return baseScore - totalPenalty;
}
