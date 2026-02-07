def get_landing_stance(start_stance, rotation):
    flips = abs(rotation) // 180

    if flips % 2 == 0:
        return start_stance

    return "Goofy" if start_stance == "Regular" else "Regular"
