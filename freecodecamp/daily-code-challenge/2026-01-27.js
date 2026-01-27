function oddOrEvenDay(timestamp) {
  const date = new Date(timestamp);
  const day = date.getUTCDate(); // day of the month (1–31)

  return day % 2 === 0 ? "even" : "odd";
}
