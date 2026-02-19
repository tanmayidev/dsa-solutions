def avalanche_risk(snow_depth, slope):
    if slope == "Gentle":
        return "Safe"
    else:
        if snow_depth == "Shallow":
            return "Safe"
        else:
            return "Risky"
