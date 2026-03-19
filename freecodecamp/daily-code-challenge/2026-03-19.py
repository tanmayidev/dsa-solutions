def invert_matrix(matrix):
    # Get unique values
    values = set()
    for row in matrix:
        for val in row:
            values.add(val)

    a, b = list(values)

    # Create new matrix with swapped values
    return [[b if val == a else a for val in row] for row in matrix]
