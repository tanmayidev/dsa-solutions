function avalancheRisk(snowDepth, slope) {
  if (slope === "Gentle") {
    return "Safe";
  } else {
    if (snowDepth === "Shallow") {
      return "Safe";
    } else {
      return "Risky";
    }
  }
}
