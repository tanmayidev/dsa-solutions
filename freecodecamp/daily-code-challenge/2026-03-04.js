function cardValues(cards) {

  return cards.map(card => {
    const value = card.slice(0, -1); // remove suit
    
    if (value === "A") return 1;
    if (["J", "Q", "K"].includes(value)) return 10;
    return parseInt(value);
  });
}
