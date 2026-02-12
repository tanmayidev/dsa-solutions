def largest_difference(skater1, skater2):
    max_diff = float('-inf')
    lap_number = -1

    for i in range(len(skater1)):
        diff = abs(skater1[i] - skater2[i])

        if diff > max_diff:
            max_diff = diff
            lap_number = i + 1  # Lap numbers are 1-based

    return lap_number
