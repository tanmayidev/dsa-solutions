function isValidIsbn10(str) {

  let s = str.replace(/-/g, "");

  // Length check
  if (s.length !== 10) return false;

  let sum = 0;

  for (let i = 0; i < 10; i++) {
    let ch = s[i];
    let value;

    if (i === 9 && ch === 'X') {
      value = 10;
    } else if (ch >= '0' && ch <= '9') {
      value = ch.charCodeAt(0) - '0'.charCodeAt(0);
    } else {
      return false;
    }

    sum += value * (i + 1);
  }

  return sum % 11 === 0;
}