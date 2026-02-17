def check_eligibility(athlete_weights, sled_weight):
    team_size = len(athlete_weights)
    
    min_sled = {1: 162, 2: 170, 4: 210}
    max_total = {1: 247, 2: 390, 4: 630}
    
    # Invalid team size
    if team_size not in min_sled:
        return "Not Eligible"
    
    total_weight = sum(athlete_weights) + sled_weight
    
    if sled_weight < min_sled[team_size]:
        return "Not Eligible"
    
    if total_weight > max_total[team_size]:
        return "Not Eligible"
    
    return "Eligible"
