def get_char_width(char):
    if char in "ilI.":
        return 1
    elif char in "fjrt ":
        return 2
    elif char in "abcdeghkmnopqrstuvwxyzJL":
        return 3
    elif char in "ABCDEFGHKMNOPQRSTUVWXYZ":
        return 4
    return 0 # Fallback for any unmapped characters

def truncate_text(s):
    total_width = sum(get_char_width(c) for c in s)
    
    # Return original string if it is 50 units or less
    if total_width <= 50:
        return s
        
    # Start with 3 to account for the "..." that will be appended
    current_width = 3 
    truncated_text = ""
    
    for char in s:
        char_width = get_char_width(char)
        # Add characters as long as we don't exceed the 50 unit limit
        if current_width + char_width <= 50:
            current_width += char_width
            truncated_text += char
        else:
            break
            
    return truncated_text + "..."
