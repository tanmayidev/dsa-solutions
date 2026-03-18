import re

def largest_number(s):
    nums = re.split(r'[,:;!?]', s)
    nums = [float(n) for n in nums]
    return max(nums)