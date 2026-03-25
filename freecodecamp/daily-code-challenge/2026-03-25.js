function canRetake(finishTime, currentTime) {
  const t1 = new Date(finishTime);
  const t2 = new Date(currentTime);

  const diff = (t2 - t1) / 1000; // seconds

  return diff >= 48 * 3600;
}