def separate_letters_and_numbers(s):
    if not s:
        return s

    result = [s[0]]

    for i in range(1, len(s)):
        prev = s[i - 1]
        curr = s[i]

        if (prev.isalpha() and curr.isdigit()) or (prev.isdigit() and curr.isalpha()):
            result.append('-')

        result.append(curr)

    return ''.join(result)
