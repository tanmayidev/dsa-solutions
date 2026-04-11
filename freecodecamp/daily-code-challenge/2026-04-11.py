def rook_bishop_attack(rook, bishop):
    # Convert columns (A-H) to numbers (1-8)
    col1, row1 = ord(rook[0]) - ord('A'), int(rook[1])
    col2, row2 = ord(bishop[0]) - ord('A'), int(bishop[1])
    
    # Rook attack (same row or column)
    if col1 == col2 or row1 == row2:
        return "rook"
    
    # Bishop attack (diagonal)
    if abs(col1 - col2) == abs(row1 - row2):
        return "bishop"
    
    return "neither"