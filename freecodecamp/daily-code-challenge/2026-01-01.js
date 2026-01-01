function resolutionStreak(days) {
  if (days.length === 0) {
    return "Resolution on track: 0 day streak.";
  }
  
  for (let i = 0; i < days.length; i++) {
    const [steps, screenTime, pagesRead] = days[i];
    
    const meetsStepsGoal = steps >= 10000;
    const meetsScreenTimeGoal = screenTime <= 120;
    const meetsPagesGoal = pagesRead >= 5;
    
    if (!meetsStepsGoal || !meetsScreenTimeGoal || !meetsPagesGoal) {
      return `Resolution failed on day ${i + 1}: ${i} day streak.`;
    }
  }
  
  return `Resolution on track: ${days.length} day streak.`;
}
