import re

def parse_inline_code(markdown):
    return re.sub(r'`([^`]+)`', r'<code>\1</code>', markdown)
