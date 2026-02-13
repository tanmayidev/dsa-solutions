function getFastestSpeed(times) {
  const distances = [320, 280, 350, 300, 250];
  
  let maxSpeed = 0;
  let segmentNumber = 0;
  
  for (let i = 0; i < 5; i++) {
    let speed = distances[i] / times[i];
    if (speed > maxSpeed) {
      maxSpeed = speed;
      segmentNumber = i + 1;
    }
  }
  
  return `The luger's fastest speed was ${maxSpeed.toFixed(2)} m/s on segment ${segmentNumber}.`;
}
