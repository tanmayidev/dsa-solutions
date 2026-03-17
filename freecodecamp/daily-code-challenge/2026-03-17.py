def get_milestone(years):

    if years >= 70: return "Platinum"
    if years >= 60: return "Diamond"
    if years >= 50: return "Gold"
    if years >= 40: return "Ruby"
    if years >= 25: return "Silver"
    if years >= 10: return "Tin"
    if years >= 5: return "Wood"
    if years >= 1: return "Paper"

    return "Newlyweds"
