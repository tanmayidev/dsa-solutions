import re

def count_letters_and_numbers(s):
    letters = len(re.findall(r"[A-Za-z]", s))
    numbers = len(re.findall(r"[0-9]", s))

    letter_word = "letter" if letters == 1 else "letters"
    number_word = "number" if numbers == 1 else "numbers"

    return f"The string has {letters} {letter_word} and {numbers} {number_word}."
