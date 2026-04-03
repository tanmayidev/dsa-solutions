function capitalizeFibonacci(str) {
  // Generate Fibonacci indices
  let fib = [0, 1];
  while (fib[fib.length - 1] < str.length) {
    fib.push(fib[fib.length - 1] + fib[fib.length - 2]);
  }

  let fibSet = new Set(fib);

  let result = "";

  for (let i = 0; i < str.length; i++) {
    let ch = str[i];

    if (!/[a-zA-Z]/.test(ch)) {
      result += ch;
    } else if (fibSet.has(i)) {
      result += ch.toUpperCase();
    } else {
      result += ch.toLowerCase();
    }
  }

  return result;
}