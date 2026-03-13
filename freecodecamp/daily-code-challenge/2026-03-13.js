function calculateParkingFee(parkTime, pickupTime) {
  let [ph, pm] = parkTime.split(":").map(Number);
  let [uh, um] = pickupTime.split(":").map(Number);

  let parkMinutes = ph * 60 + pm;
  let pickupMinutes = uh * 60 + um;

  let overnightFee = 0;
  if (pickupMinutes < parkMinutes) {
    pickupMinutes += 24 * 60;
    overnightFee = 10;
  }

  let totalMinutes = pickupMinutes - parkMinutes;
  let hours = Math.ceil(totalMinutes / 60);

  let cost = hours * 3 + overnightFee;
  cost = Math.max(cost, 5);

  return `$${cost}`;
}
