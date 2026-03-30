function getDueDate(dateStr) {
  const [year, month, day] = dateStr.split("-").map(Number);

  // Add 9 months
  let newMonth = month + 9;
  let newYear = year + Math.floor((newMonth - 1) / 12);
  newMonth = ((newMonth - 1) % 12) + 1;

  // Get last day of target month
  const lastDay = new Date(newYear, newMonth, 0).getDate();

  // Adjust day if needed
  const newDay = Math.min(day, lastDay);

  return `${newYear.toString().padStart(4, "0")}-${newMonth
    .toString()
    .padStart(2, "0")}-${newDay.toString().padStart(2, "0")}`;
}