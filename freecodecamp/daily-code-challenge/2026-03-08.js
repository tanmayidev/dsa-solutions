function isValidHSL(hsl) {
  const regex = /^hsl\(\s*(\d+)\s*,\s*(\d+)%\s*,\s*(\d+)%\s*\)\s*;?\s*$/;

  const match = hsl.match(regex);
  if (!match) return false;

  const h = Number(match[1]);
  const s = Number(match[2]);
  const l = Number(match[3]);

  return h >= 0 && h <= 360 &&
         s >= 0 && s <= 100 &&
         l >= 0 && l <= 100;
}
