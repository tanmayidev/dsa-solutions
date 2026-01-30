def find_pawn_moves(position):
    col = position[0]
    row = int(position[1])
    moves = []

    # one square forward
    if row < 8:
        moves.append(f"{col}{row + 1}")

    # two squares forward if on starting rank
    if row == 2:
        moves.append(f"{col}{row + 2}")

    return sorted(moves)
