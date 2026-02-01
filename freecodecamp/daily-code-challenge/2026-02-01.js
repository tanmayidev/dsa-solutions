```

Given an array of your login logs, determine whether you have met your digital detox goal.

Each log is a string in the format "YYYY-MM-DD HH:mm:ss".

You have met your digital detox goal if both of the following statements are true:

You logged in no more than once within any four-hour period.
You logged in no more than 2 times on any single day.

Test Cases : 
1. digital_detox(["2026-02-01 08:00:00", "2026-02-01 12:30:00"]) should return True.
2. digital_detox(["2026-02-01 04:00:00", "2026-02-01 07:30:00"]) should return False.
3. digital_detox(["2026-01-31 08:21:30", "2026-01-31 14:30:00", "2026-02-01 08:00:00", "2026-02-01 12:30:00"]) should return True.
4. digital_detox(["2026-01-31 10:40:21", "2026-01-31 15:19:41", "2026-01-31 21:49:50", "2026-02-01 09:30:00"]) should return False.
5. digital_detox(["2026-02-05 10:00:00", "2026-02-01 09:00:00", "2026-02-03 22:15:00", "2026-02-02 12:10:00", "2026-02-02 07:15:00", "2026-02-04 09:45:00", "2026-02-01 16:50:00", "2026-02-03 09:30:00"]) should return True.
6. digital_detox(["2026-02-05 10:00:00", "2026-02-01 09:00:00", "2026-02-03 22:15:00", "2026-02-02 12:10:00", "2026-02-02 07:15:00", "2026-02-04 01:45:00", "2026-02-01 16:50:00", "2026-02-03 09:30:00"]) should return False.

```

function digitalDetox(logs) {
  // Convert to Date objects and sort
  const times = logs
    .map(log => new Date(log.replace(" ", "T")))
    .sort((a, b) => a - b);

  const FOUR_HOURS = 4 * 60 * 60 * 1000;
  const dailyCount = {};

  for (let i = 0; i < times.length; i++) {
    // Rule 1: 4-hour gap
    if (i > 0 && times[i] - times[i - 1] < FOUR_HOURS) {
      return false;
    }

    // Rule 2: max 2 per day
    const day = times[i].toISOString().split("T")[0];
    dailyCount[day] = (dailyCount[day] || 0) + 1;

    if (dailyCount[day] > 2) {
      return false;
    }
  }

  return true;
}
