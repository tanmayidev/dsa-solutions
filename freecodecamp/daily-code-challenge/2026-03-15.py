def get_captured_value(pieces):

    start = {"P":8, "R":2, "N":2, "B":2, "Q":1, "K":1}
    values = {"P":1, "R":5, "N":3, "B":3, "Q":9, "K":0}

    count = {"P":0, "R":0, "N":0, "B":0, "Q":0, "K":0}

    for p in pieces:
        count[p] += 1

    if count["K"] == 0:
        return "Checkmate"

    total = 0
    for p in start:
        captured = start[p] - count[p]
        total += captured * values[p]

    return total
