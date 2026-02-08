def calculate_penalty_distance(rounds):
    penalty = 0

    for hits in rounds:
        penalty += (5 - hits) * 150

    return penalty
