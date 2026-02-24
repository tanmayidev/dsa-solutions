function countBusinessDays(start, end) {
  const startDate = new Date(start);
  const endDate = new Date(end);
  
  let count = 0;
  let current = new Date(startDate);
  
  while (current <= endDate) {
    const day = current.getDay(); // Sunday=0, Saturday=6
    if (day !== 0 && day !== 6) {
      count++;
    }
    current.setDate(current.getDate() + 1);
  }
  
  return count;
}
