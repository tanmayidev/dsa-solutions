def shift_matrix(matrix, shift):
    if not matrix or not matrix[0]:
        return matrix

    rows = len(matrix)
    cols = len(matrix[0])
    total = rows * cols

    # Normalize shift
    shift %= total

    # Flatten matrix
    flat = [matrix[r][c] for r in range(rows) for c in range(cols)]

    # Shift using slicing
    shifted = flat[-shift:] + flat[:-shift]

    # Rebuild matrix
    result = []
    for r in range(rows):
        row = shifted[r * cols:(r + 1) * cols]
        result.append(row)

    return result
