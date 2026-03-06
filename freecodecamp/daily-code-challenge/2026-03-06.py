def navigate_trail(trail_map):
    rows = len(trail_map)
    cols = len(trail_map[0])

    grid = [list(row) for row in trail_map]

    start = None
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == "C":
                start = (r, c)

    directions = [
        (0, 1, "R"),
        (1, 0, "D"),
        (0, -1, "L"),
        (-1, 0, "U")
    ]

    r, c = start
    prev = None
    result = ""

    while grid[r][c] != "G":
        for dr, dc, move in directions:
            nr, nc = r + dr, c + dc

            if (0 <= nr < rows and 0 <= nc < cols and
                grid[nr][nc] in ("T", "G") and
                prev != (nr, nc)):

                prev = (r, c)
                r, c = nr, nc
                result += move
                break

    return result
