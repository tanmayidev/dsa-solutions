def card_values(cards):
    values = []
    
    for card in cards:
        value = card[:-1]  # remove suit (last character)
        
        if value == "A":
            values.append(1)
        elif value in ["J", "Q", "K"]:
            values.append(10)
        else:
            values.append(int(value))
    
    return values
