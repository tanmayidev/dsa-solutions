function getBingoLetter(n) {
  if (n >=1 && n <=15) {
    return "B";
  } else if (n >=16 && n<=30) {
    return "I";
  } else if (n >=31 && n<=45) {
    return "N";
  } else if (n >=46 && n<=60) {
    return "G";
  } else if (n >=61 && n<=75) {
    return "O";
  }
}
