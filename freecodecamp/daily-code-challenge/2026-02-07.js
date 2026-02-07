function getLandingStance(startStance, rotation) {
  const flips = Math.floor(Math.abs(rotation) / 180);

  if (flips % 2 === 0) {
    return startStance;
  }

  return startStance === "Regular" ? "Goofy" : "Regular";
}
