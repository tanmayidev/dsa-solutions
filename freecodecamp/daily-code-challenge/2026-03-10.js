function insertIntoArray(arr, value, index) {
  return [...arr.slice(0, index), value, ...arr.slice(index)];
}
