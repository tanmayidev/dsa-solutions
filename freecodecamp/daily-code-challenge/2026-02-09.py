def ski_jump_medal(distance_points, style_points, wind_comp, k_point_bonus):
    other_scores = [
        165.5, 172.0, 158.0, 180.0,
        169.5, 175.0, 162.0, 170.0
    ]

    your_score = distance_points + style_points + wind_comp + k_point_bonus

    all_scores = other_scores + [your_score]
    all_scores.sort(reverse=True)

    rank = all_scores.index(your_score) + 1

    if rank == 1:
        return "Gold"
    elif rank == 2:
        return "Silver"
    elif rank == 3:
        return "Bronze"
    else:
        return "No Medal"
