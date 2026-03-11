def convert_words(s):
    return " ".join(str(len(word)) for word in s.split(" "))
