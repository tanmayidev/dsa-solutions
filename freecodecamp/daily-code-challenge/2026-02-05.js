function countChange(change) {
  const totalCents = change.reduce((sum, coin) => sum + coin, 0);
  const dollars = Math.floor(totalCents / 100);
  const cents = totalCents % 100;
  return `$${dollars}.${cents.toString().padStart(2, '0')}`;
}
