function isFizzBuzz(arr) {
  // Find the starting number
  let start = null;

  for (let i = 0; i < arr.length; i++) {
    if (typeof arr[i] === "number") {
      start = arr[i] - i;
      break;
    }
  }

  if (start === null) return false;

  for (let i = 0; i < arr.length; i++) {
    let num = start + i;

    let expected =
      num % 15 === 0 ? "FizzBuzz" :
      num % 3 === 0 ? "Fizz" :
      num % 5 === 0 ? "Buzz" :
      num;

    if (arr[i] !== expected) {
      return false;
    }
  }

  return true;
}