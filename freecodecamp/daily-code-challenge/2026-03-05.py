def smallest_gap(s):
    last_seen = {}
    min_gap = float('inf')
    result = ""

    for i, char in enumerate(s):
        if char in last_seen:
            gap = i - last_seen[char] - 1

            if gap < min_gap:
                min_gap = gap
                result = s[last_seen[char] + 1:i]

        last_seen[char] = i

    return result
