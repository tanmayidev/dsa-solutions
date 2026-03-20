def get_shadow(time):
    h, m = map(int, time.split(":"))
    t = h + m / 60

    if t < 6 or t >= 18 or t == 12:
        return "No shadow"

    diff = abs(12 - t)
    length = diff ** 3

    if length.is_integer():
        length = int(length)

    direction = "west" if t < 12 else "east"

    return f"{length}ft {direction}"