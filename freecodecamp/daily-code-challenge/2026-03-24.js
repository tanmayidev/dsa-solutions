function passingCount(scores, passingScore) {
  return scores.filter(score => score >= passingScore).length;
}