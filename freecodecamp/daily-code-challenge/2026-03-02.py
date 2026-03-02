def sum_letters(s):
    total = 0

    for char in s:
        if char.isalpha():
            total += ord(char.lower()) - 96

    return total
