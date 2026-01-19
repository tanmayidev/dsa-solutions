const JOULES_IN_CALORIE = 4184;
const JOULES_IN_WATTHOUR = 3600;

function compareEnergy(caloriesBurned, wattHoursUsed) {
  const caloriesBurnedInJoules = caloriesBurned * JOULES_IN_CALORIE;
  const wattHoursUsedInJoules = wattHoursUsed * JOULES_IN_WATTHOUR;

  return (caloriesBurnedInJoules === wattHoursUsedInJoules 
    ? "Equal" 
    : caloriesBurnedInJoules > wattHoursUsedInJoules
      ? "Workout"
      : "Devices");
}
