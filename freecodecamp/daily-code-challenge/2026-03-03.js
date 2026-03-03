function countPerfectCubes(a, b) {
  const low = Math.min(a, b);
  const high = Math.max(a, b);

  const start = Math.ceil(Math.cbrt(low));
  const end = Math.floor(Math.cbrt(high));

  return Math.max(0, end - start + 1);
}
