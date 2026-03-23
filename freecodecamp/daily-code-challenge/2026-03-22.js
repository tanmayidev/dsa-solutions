function detectRoast(beans) {
  let total = 0;

  for (let ch of beans) {
    if (ch === "'") total += 1;
    else if (ch === "-") total += 2;
    else if (ch === ".") total += 3;
  }

  let avg = total / beans.length;

  if (avg < 1.75) return "Light";
  else if (avg <= 2.5) return "Medium";
  else return "Dark";
}