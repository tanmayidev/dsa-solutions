function getMovieNightCost(day, showtime, numberOfTickets) {
  // Step 1: Tuesday special
  if (day === "Tuesday") {
    return `$${(5 * numberOfTickets).toFixed(2)}`;
  }

  // Step 2: Base price
  let pricePerTicket;
  if (["Friday", "Saturday", "Sunday"].includes(day)) {
    pricePerTicket = 12;
  } else {
    pricePerTicket = 10;
  }

  // Step 3: Check matinee
  let time = showtime.slice(0, -2); // remove am/pm
  let period = showtime.slice(-2);

  let [hour, minute] = time.split(":").map(Number);

  if (period === "pm" && hour !== 12) hour += 12;
  if (period === "am" && hour === 12) hour = 0;

  let isMatinee = hour < 17; // before 5pm

  if (isMatinee) {
    pricePerTicket -= 2;
  }

  let total = pricePerTicket * numberOfTickets;

  return `$${total.toFixed(2)}`;
}