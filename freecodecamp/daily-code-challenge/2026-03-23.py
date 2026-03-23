def has_no_repeats(s):
    for i in range(1, len(s)):
        if s[i] == s[i - 1]:
            return False
    return True