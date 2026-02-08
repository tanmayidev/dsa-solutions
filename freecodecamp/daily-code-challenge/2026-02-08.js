function calculatePenaltyDistance(rounds) {
  let penalty = 0;

  for (let hits of rounds) {
    penalty += (5 - hits) * 150;
  }

  return penalty;
}
