function isValidEquation(equation) {
  const [left, right] = equation.split("=");
  const target = Number(right.trim());

  // Tokenize (split by space)
  let tokens = left.trim().split(" ");

  // Step 1: handle * and /
  let stack = [];
  stack.push(Number(tokens[0]));

  for (let i = 1; i < tokens.length; i += 2) {
    let operator = tokens[i];
    let num = Number(tokens[i + 1]);

    if (operator === "*") {
      stack[stack.length - 1] *= num;
    } else if (operator === "/") {
      stack[stack.length - 1] /= num;
    } else {
      stack.push(operator);
      stack.push(num);
    }
  }

  // Step 2: handle + and -
  let result = stack[0];
  for (let i = 1; i < stack.length; i += 2) {
    let operator = stack[i];
    let num = stack[i + 1];

    if (operator === "+") result += num;
    else result -= num;
  }

  return result === target;
}