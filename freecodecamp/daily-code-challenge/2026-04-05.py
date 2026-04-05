def get_rotation(n):
    s = str(n)
    k = len(s)

    for i in range(k):
        num = int(s)

        if num % k == 0:
            return i

        # rotate: move first digit to end
        s = s[1:] + s[0]

    return "none"