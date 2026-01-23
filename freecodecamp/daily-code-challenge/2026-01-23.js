function isValidHex(str) {
  const regex = /^#[0-9a-fA-F]+$/
  return str.length <= 7 ? regex.test(str) : false;
}
