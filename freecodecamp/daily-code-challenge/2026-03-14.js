function getPiDecimal(n) {
  let target = n + 1;

  let q = 1n, r = 0n, t = 1n, k = 1n, n1 = 3n, l = 3n;
  let digits = [];

  while (digits.length < target) {
    if (4n*q + r - t < n1*t) {
      digits.push(Number(n1));

      let newQ = 10n*q;
      let newR = 10n*(r - n1*t);
      let newN = ((10n*(3n*q + r)) / t) - 10n*n1;

      q = newQ;
      r = newR;
      n1 = newN;
    } else {
      let newQ = q*k;
      let newR = (2n*q + r)*l;
      let newT = t*l;
      let newK = k + 1n;
      let newN = (q*(7n*k) + 2n + r*l) / (t*l);
      let newL = l + 2n;

      q = newQ;
      r = newR;
      t = newT;
      k = newK;
      n1 = newN;
      l = newL;
    }
  }

  return digits[n];
}
