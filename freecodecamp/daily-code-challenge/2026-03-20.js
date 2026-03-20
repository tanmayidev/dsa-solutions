function getShadow(time) {
  let [h, m] = time.split(":").map(Number);
  let t = h + m / 60;

  if (t < 6 || t >= 18 || t === 12) return "No shadow";

  let diff = Math.abs(12 - t);
  let length = diff ** 3;

  let direction = t < 12 ? "west" : "east";

  return `${length}ft ${direction}`;
}