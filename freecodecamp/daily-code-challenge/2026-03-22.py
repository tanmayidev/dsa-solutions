def detect_roast(beans):
    total = 0

    for ch in beans:
        if ch == "'":
            total += 1
        elif ch == "-":
            total += 2
        elif ch == ".":
            total += 3

    avg = total / len(beans)

    if avg < 1.75:
        return "Light"
    elif avg <= 2.5:
        return "Medium"
    else:
        return "Dark"