function toConsonantCase(str) {
  const vowels = ['a', 'e', 'i', 'o', 'u'];

  return str
    .split('')
    .map(char => {
      if (char === '-') {
        return '_';
      }

      if (vowels.includes(char.toLowerCase())) {
        return char.toLowerCase();
      }

      if (/[a-z]/i.test(char)) {
        return char.toUpperCase();
      }

      return char;
    })
    .join('');
}
