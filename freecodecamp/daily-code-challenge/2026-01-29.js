function separateLettersAndNumbers(str) {
  if (!str) return str;

  let result = str[0];

  for (let i = 1; i < str.length; i++) {
    const prev = str[i - 1];
    const curr = str[i];

    const isPrevLetter = /[a-zA-Z]/.test(prev);
    const isCurrLetter = /[a-zA-Z]/.test(curr);
    const isPrevDigit = /[0-9]/.test(prev);
    const isCurrDigit = /[0-9]/.test(curr);

    if (
      (isPrevLetter && isCurrDigit) ||
      (isPrevDigit && isCurrLetter)
    ) {
      result += '-';
    }

    result += curr;
  }

  return result;
}
