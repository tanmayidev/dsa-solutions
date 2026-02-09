function skiJumpMedal(distancePoints, stylePoints, windComp, kPointBonus) {
  const otherScores = [
    165.5, 172.0, 158.0, 180.0,
    169.5, 175.0, 162.0, 170.0
  ];

  const yourScore =
    distancePoints + stylePoints + windComp + kPointBonus;

  const allScores = [...otherScores, yourScore].sort((a, b) => b - a);
  const rank = allScores.indexOf(yourScore) + 1;

  if (rank === 1) return "Gold";
  if (rank === 2) return "Silver";
  if (rank === 3) return "Bronze";
  return "No Medal";
}
