import re

def is_valid_hsl(hsl):
    pattern = r'^hsl\(\s*(\d+)\s*,\s*(\d+)%\s*,\s*(\d+)%\s*\)\s*;?\s*$'
    
    match = re.match(pattern, hsl)
    if not match:
        return False
    
    h = int(match.group(1))
    s = int(match.group(2))
    l = int(match.group(3))
    
    return 0 <= h <= 360 and 0 <= s <= 100 and 0 <= l <= 100
