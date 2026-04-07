def palindrome_locator(s):
    # Check palindrome
    if s != s[::-1]:
        return "none"

    length = len(s)
    mid = length // 2

    # Odd length
    if length % 2 != 0:
        return s[mid]

    # Even length
    return s[mid - 1] + s[mid]