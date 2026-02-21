def score_curling(house):
    center = (2, 2)
    
    def ring_distance(r, c):
        return max(abs(r - center[0]), abs(c - center[1]))
    
    stones = {"R": [], "Y": []}
    
    for r in range(5):
        for c in range(5):
            if house[r][c] in stones:
                stones[house[r][c]].append(ring_distance(r, c))
    
    if not stones["R"] and not stones["Y"]:
        return "No points awarded"
    
    if not stones["R"]:
        scoring_team = "Y"
    elif not stones["Y"]:
        scoring_team = "R"
    else:
        min_r = min(stones["R"])
        min_y = min(stones["Y"])
        
        if min_r == min_y:
            return "No points awarded"
        
        scoring_team = "R" if min_r < min_y else "Y"
    
    opponent = "Y" if scoring_team == "R" else "R"
    opponent_min = min(stones[opponent]) if stones[opponent] else float("inf")
    
    points = sum(1 for d in stones[scoring_team] if d < opponent_min)
    
    return f"{scoring_team}: {points}"
