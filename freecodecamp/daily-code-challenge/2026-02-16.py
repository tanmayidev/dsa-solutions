def get_semifinal_matchups(teams):
    standings = []
    
    for team in teams:
        name, record = team.split(": ")
        W, OTW, OTL, L = map(int, record.split("-"))
        
        points = (W * 3) + (OTW * 2) + (OTL * 1)
        standings.append((name, points))
    
    # Sort by points descending
    standings.sort(key=lambda x: x[1], reverse=True)
    
    return f"The semi-final games will be {standings[0][0]} vs {standings[3][0]} and {standings[1][0]} vs {standings[2][0]}."
