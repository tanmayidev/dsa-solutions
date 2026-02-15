function getHillRating(drop, distance, type) {
  const steepness = drop / distance;
  let adjusted;

  if (type === "Downhill") {
    adjusted = steepness * 1.2;
  } else if (type === "Slalom") {
    adjusted = steepness * 0.9;
  } else if (type === "Giant Slalom") {
    adjusted = steepness * 1.0;
  } else {
    adjusted = steepness;
  }

  if (adjusted <= 0.1) {
    return "Green";
  } else if (adjusted <= 0.25) {
    return "Blue";
  } else {
    return "Black";
  }
}
