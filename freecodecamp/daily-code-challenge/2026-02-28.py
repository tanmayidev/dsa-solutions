import re

def add_punctuation(sentences):
    result = re.sub(r"\s(?=[A-Z])", ". ", sentences)
    
    # Add period at end if not already present
    if not result.endswith("."):
        result += "."
        
    return result
