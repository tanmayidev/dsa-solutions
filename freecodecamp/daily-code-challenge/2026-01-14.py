"""
Given the string of a link in Markdown, return the equivalent HTML string.

A Markdown image has the following format: "[link_text](link_url)". Return the string of the HTML a tag with the href set to the link_url and the link_text as the tag content.

For example, given "[freeCodeCamp](https://freecodecamp.org/)" return '<a href="https://freecodecamp.org/">freeCodeCamp</a>';

Note: The console may not display HTML tags in strings when logging messages — check the browser console to see logs with tags included.

Test Cases : 
1. parseLink("[freeCodeCamp](https://freecodecamp.org/)") should return '<a href="https://freecodecamp.org/">freeCodeCamp</a>'.
2. parseLink("[Donate to our charity.](https://www.freecodecamp.org/donate/)") should return '<a href="https://www.freecodecamp.org/donate/">Donate to our charity.</a>'.
3. parseLink("[Contribute to our repository at https://github.com/freeCodeCamp/freeCodeCamp.](https://github.com/freeCodeCamp/freeCodeCamp/)") should return '<a href="https://github.com/freeCodeCamp/freeCodeCamp/">Contribute to our repository at https://github.com/freeCodeCamp/freeCodeCamp.</a>'.

"""

import re

def parse_link(markdown):
    # Extract link_text and link_url using regex
    match = re.match(r'\[([^\]]+)\]\(([^)]+)\)', markdown)
    
    if match:
        link_text = match.group(1)
        link_url = match.group(2)
        return f'<a href="{link_url}">{link_text}</a>'
    
    return markdown 
