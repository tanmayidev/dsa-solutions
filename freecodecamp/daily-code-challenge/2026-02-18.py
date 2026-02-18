def calculate_start_delays(jump_scores):
    import math
    
    best_score = max(jump_scores)
    
    return [math.ceil((best_score - score) * 1.5) for score in jump_scores]
