def compute_score(judge_scores, *penalties):
    # Remove one highest and one lowest score
    scores = sorted(judge_scores)
    base_score = sum(scores[1:-1])
    
    # Subtract penalties
    total_penalty = sum(penalties)
    
    return base_score - total_penalty
