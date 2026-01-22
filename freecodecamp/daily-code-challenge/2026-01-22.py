def get_average_grade(scores):

    average = sum(scores) / len(scores)
    
    if average >= 97:
        return "A+"
    elif average >= 93:
        return "A"
    elif average >= 90:
        return "A-"
    elif average >= 87:
        return "B+"
    elif average >= 83:
        return "B"
    elif average >= 80:
        return "B-"
    elif average >= 77:
        return "C+"
    elif average >= 73:
        return "C"
    elif average >= 70:
        return "C-"
    elif average >= 67:
        return "D+"
    elif average >= 63:
        return "D"
    elif average >= 60:
        return "D-"
    else:
        return "F"
