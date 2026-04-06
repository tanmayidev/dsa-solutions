function getDayOfWeek(timestamp) {
    const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    const date = new Date(timestamp);
    return days[date.getUTCDay()];
}