def to_consonant_case(s):
    vowels = {'a', 'e', 'i', 'o', 'u'}

    return ''.join(
        '_' if ch == '-' else
        ch.lower() if ch.lower() in vowels else
        ch.upper() if ch.isalpha() else
        ch
        for ch in s
    )
