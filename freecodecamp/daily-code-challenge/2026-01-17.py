"""
Knight Moves
Given the position of a knight on a chessboard, return the number of valid squares the knight can move to.

A standard chessboard is 8x8, with columns labeled A through H (left to right) and rows labeled 1 through 8 (bottom to top). It looks like this:

A8	B8	C8	D8	E8	F8	G8	H8
A7	B7	C7	D7	E7	F7	G7	H7
A6	B6	C6	D6	E6	F6	G6	H6
A5	B5	C5	D5	E5	F5	G5	H5
A4	B4	C4	D4	E4	F4	G4	H4
A3	B3	C3	D3	E3	F3	G3	H3
A2	B2	C2	D2	E2	F2	G2	H2
A1	B1	C1	D1	E1	F1	G1	H1
A knight moves in an "L" shape: two squares in one direction (horizontal or vertical), and one square in the perpendicular direction.

This means a knight can move to up to eight possible positions, but fewer when near the edges of the board. For example, if a knight was at A1, it could only move to B3 or C2.

Test Cases : 
1. knightMoves("A1") should return 2.
2. knightMoves("D4") should return 8.
3. knightMoves("G6") should return 6.
4. knightMoves("B8") should return 3.
5. knightMoves("H3") should return 4.
"""

def knight_moves(position):

    col = position[0]  # Letter A-H
    row = int(position[1])  # Number 1-8
    
    # Convert column letter to number (A=1, B=2, ..., H=8)
    col_num = ord(col) - ord('A') + 1
    
    # All possible knight move offsets (2 in one direction, 1 in perpendicular)
    knight_moves = [
        (2, 1),   # 2 right, 1 up
        (2, -1),  # 2 right, 1 down
        (-2, 1),  # 2 left, 1 up
        (-2, -1), # 2 left, 1 down
        (1, 2),   # 1 right, 2 up
        (1, -2),  # 1 right, 2 down
        (-1, 2),  # 1 left, 2 up
        (-1, -2)  # 1 left, 2 down
    ]
    
    valid_moves = 0
    
    # Check each possible move
    for dc, dr in knight_moves:
        new_col = col_num + dc
        new_row = row + dr
        
        # Check if the new position is within the board (1-8 for both col and row)
        if 1 <= new_col <= 8 and 1 <= new_row <= 8:
            valid_moves += 1
    
    return valid_moves
