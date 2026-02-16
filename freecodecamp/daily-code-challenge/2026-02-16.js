function getSemifinalMatchups(teams) {
  const standings = teams.map(team => {
    const [name, record] = team.split(": ");
    const [W, OTW, OTL, L] = record.split("-").map(Number);
    
    const points = (W * 3) + (OTW * 2) + (OTL * 1);
    
    return { name, points };
  });

  // Sort by points descending
  standings.sort((a, b) => b.points - a.points);

  return `The semi-final games will be ${standings[0].name} vs ${standings[3].name} and ${standings[1].name} vs ${standings[2].name}.`;
}
