function getRelativeResults(results) {
  // helper: convert H:MM:SS to seconds
  const toSeconds = (time) => {
    const [h, m, s] = time.split(":").map(Number);
    return h * 3600 + m * 60 + s;
  };

  const winnerTime = toSeconds(results[0]);

  return results.map((time, index) => {
    if (index === 0) return "0";

    const diff = toSeconds(time) - winnerTime;
    const minutes = Math.floor(diff / 60);
    const seconds = diff % 60;

    return `+${minutes}:${String(seconds).padStart(2, "0")}`;
  });
}
