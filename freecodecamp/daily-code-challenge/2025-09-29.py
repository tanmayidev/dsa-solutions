"""

Longest Word

Given a sentence, return the longest word in the sentence.
- Ignore periods (.) when determining word length.
- If multiple words are ties for the longest, return the first one that occurs.


Examples : 
1. getLongestWord("coding is fun") should return "coding".
2. getLongestWord("Coding challenges are fun and educational.") should return "educational".
3. getLongestWord("This sentence has multiple long words.") should return "sentence".

"""

def get_longest_word(sentence):
    if not sentence or not isinstance(sentence, str):
        return ''
    
    words = sentence.replace('.', '').split()
    
    if not words:
        return ''
    
    return max(words, key=len)

# Brute Force

def get_longest_word(sentence):
    if not sentence or not isinstance(sentence, str):
        return ''
    
    # Remove periods
    sentence = sentence.replace('.', '')
    
    # Split into words
    words = sentence.split()
    
    if not words:
        return ''
    
    # Brute force: iterate through all words
    longest_word = ''
    longest_length = 0
    
    for word in words:
        word_length = len(word)
        if word_length > longest_length:
            longest_length = word_length
            longest_word = word
    
    return longest_word
