function sumLetters(str) {
  let sum = 0;

  for (let char of str) {
    if (/[a-zA-Z]/.test(char)) {
      sum += char.toLowerCase().charCodeAt(0) - 96;
    }
  }

  return sum;
}
