def get_next_bingo_number(n):
    letter = n[0]
    number = int(n[1:])
    
    ranges = {
        "B": (1, 15, "I"),
        "I": (16, 30, "N"),
        "N": (31, 45, "G"),
        "G": (46, 60, "O"),
        "O": (61, 75, "B")
    }
    
    start, end, next_letter = ranges[letter]
    
    if number < end:
        return f"{letter}{number + 1}"
    else:
        # move to next letter range
        next_start = ranges[next_letter][0]
        return f"{next_letter}{next_start}"