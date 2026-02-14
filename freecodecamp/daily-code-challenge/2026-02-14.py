def get_difficulty(track):
    score = 0
    
    for i in range(len(track)):
        if track[i] in ("L", "R"):
            if i > 0 and (
                (track[i] == "L" and track[i-1] == "R") or
                (track[i] == "R" and track[i-1] == "L")
            ):
                score += 15
            else:
                score += 5
    
    if score <= 100:
        return "Easy"
    elif score <= 200:
        return "Medium"
    else:
        return "Hard"
