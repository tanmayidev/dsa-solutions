function convertWords(str) {

  return str
    .split(" ")
    .map(word => word.length)
    .join(" ");
}
