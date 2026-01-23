import re

def is_valid_hex(s):
    return len(s) <= 7 and bool(re.match(r'^#[0-9a-fA-F]+$', s))
