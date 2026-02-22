function countMedals(winners) {
  const table = {};

  for (const [gold, silver, bronze] of winners) {
    if (!table[gold]) table[gold] = [0, 0, 0];
    if (!table[silver]) table[silver] = [0, 0, 0];
    if (!table[bronze]) table[bronze] = [0, 0, 0];

    table[gold][0] += 1;
    table[silver][1] += 1;
    table[bronze][2] += 1;
  }

  const countries = Object.keys(table);

  countries.sort((a, b) => {
    if (table[b][0] !== table[a][0]) {
      return table[b][0] - table[a][0]; // sort by gold descending
    }
    return a.localeCompare(b); // alphabetical if tie
  });

  let result = "Country,Gold,Silver,Bronze,Total";

  for (const country of countries) {
    const [g, s, b] = table[country];
    const total = g + s + b;
    result += `\n${country},${g},${s},${b},${total}`;
  }

  return result;
}
