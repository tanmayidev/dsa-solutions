function isValidTrick(trickName) {
  const validFirst = ["Misty", "Ghost", "Thunder", "Solar", "Sky", "Phantom", "Frozen", "Polar"];
  const validSecond = ["Twister", "Icequake", "Avalanche", "Vortex", "Snowstorm", "Frostbite", "Blizzard", "Shadow"];
  
  const [first, second] = trickName.split(" ");
  return validFirst.includes(first) && validSecond.includes(second);
}
