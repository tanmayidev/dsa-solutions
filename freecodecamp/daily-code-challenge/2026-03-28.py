def pascal_row(n):
    if n <= 0:
        return []

    row = [1]
    prev = 1

    for k in range(1, n):
        curr = prev * (n - k) // k
        row.append(curr)
        prev = curr

    return row