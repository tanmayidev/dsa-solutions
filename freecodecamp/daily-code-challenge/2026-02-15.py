def get_hill_rating(drop, distance, hill_type):
    steepness = drop / distance
    
    if hill_type == "Downhill":
        adjusted = steepness * 1.2
    elif hill_type == "Slalom":
        adjusted = steepness * 0.9
    elif hill_type == "Giant Slalom":
        adjusted = steepness * 1.0
    else:
        adjusted = steepness
    
    if adjusted <= 0.1:
        return "Green"
    elif adjusted <= 0.25:
        return "Blue"
    else:
        return "Black"
