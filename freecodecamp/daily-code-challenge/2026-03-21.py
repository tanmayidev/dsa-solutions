def rotate(mat):
    return [''.join(row[i] for row in reversed(mat)) for i in range(6)]

def is_valid(mat):
    def check(r, c):
        return (mat[r][c] == '1' and mat[r][c+1] == '1' and
                mat[r+1][c] == '1' and mat[r+1][c+1] == '1')
    
    return check(0, 0) and check(0, 4) and check(4, 0)

def decode_qr(qr_code):
    mat = qr_code
    
    # Try all 4 rotations
    for _ in range(4):
        if is_valid(mat):
            break
        mat = rotate(mat)
    
    result = []
    
    for i in range(6):
        for j in range(6):
            # Skip 3 orientation blocks
            if (i < 2 and j < 2) or (i < 2 and j >= 4) or (i >= 4 and j < 2):
                continue
            result.append(mat[i][j])
    
    return ''.join(result)
