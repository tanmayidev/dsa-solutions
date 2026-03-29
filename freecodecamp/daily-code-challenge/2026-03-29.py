def is_valid_isbn10(s):

    s = s.replace("-", "")

    if len(s) != 10:
        return False

    total = 0

    for i in range(10):
        ch = s[i]

        if i == 9 and ch == 'X':
            value = 10
        elif ch.isdigit():
            value = int(ch)
        else:
            return False

        total += value * (i + 1)

    return total % 11 == 0