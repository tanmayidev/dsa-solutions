"""
vOwElcAsE
Given a string, return a new string where all vowels are converted to uppercase and all other alphabetical characters are converted to lowercase.

Vowels are "a", "e", "i", "o", and "u" in any case.
Non-alphabetical characters should remain unchanged.

Test Cases 
1. vowelCase("vowelcase") should return "vOwElcAsE".
2. vowelCase("coding is fun") should return "cOdIng Is fUn".
3. vowelCase("HELLO, world!") should return "hEllO, wOrld!".
4. vowelCase("git cherry-pick") should return "gIt chErry-pIck".
5. vowelCase("HEAD~1") should return "hEAd~1".
"""

def case_helper(c):
    smallC = c.lower()

    match smallC:
        case 'a': return c.upper()
        case 'e': return c.upper()
        case 'i': return c.upper()
        case 'o': return c.upper()
        case 'u': return c.upper()
        case _: return c.lower()

def vowel_case(s):
    result = ""
    sList = list(s)

    for character in sList:
        result += case_helper(character)

    return result
