function alarmCheck(alarmTime, wakeTime) {
  const toMinutes = (time) => {
    const [h, m] = time.split(":").map(Number);
    return h * 60 + m;
  };

  const alarm = toMinutes(alarmTime);
  const wake = toMinutes(wakeTime);

  if (wake < alarm) return "early";
  if (wake <= alarm + 10) return "on time";
  return "late";
}