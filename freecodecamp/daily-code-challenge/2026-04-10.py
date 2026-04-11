def rook_attack(rook1, rook2):
    col1, row1 = rook1[0], rook1[1]
    col2, row2 = rook2[0], rook2[1]
    
    return col1 == col2 or row1 == row2