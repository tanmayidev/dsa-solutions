function checkEligibility(athleteWeights, sledWeight) {
  const teamSize = athleteWeights.length;
  
  const minSled = { 1: 162, 2: 170, 4: 210 };
  const maxTotal = { 1: 247, 2: 390, 4: 630 };
  
  if (!minSled[teamSize]) return "Not Eligible";
  
  const totalWeight = athleteWeights.reduce((sum, w) => sum + w, 0) + sledWeight;
  
  if (sledWeight < minSled[teamSize]) return "Not Eligible";
  if (totalWeight > maxTotal[teamSize]) return "Not Eligible";
  
  return "Eligible";
}
