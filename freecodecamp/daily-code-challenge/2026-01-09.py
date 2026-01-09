"""
Circular Prime
Given an integer, determine if it is a circular prime.

A circular prime is an integer where all rotations of its digits are themselves prime.

For example, 197 is a circular prime because all rotations of its digits: 197, 971, and 719, are prime numbers.

Test Cases : 
1. is_circular_prime(197) should return True.
2. is_circular_prime(23) should return False.
3. is_circular_prime(13) should return True.
4. is_circular_prime(89) should return False.
5. is_circular_prime(1193) should return True.
"""

def is_prime(num):
    # Check if a number is prime
    if num < 2:
        return False
    if num == 2:
        return True
    if num % 2 == 0:
        return False
    
    i = 3
    while i <= num**0.5:
        if num % i == 0:
            return False
        i += 2
    
    return True


def get_rotations(num):
    # Get all rotations of a number
    str_num = str(num)
    rotations = []
    
    for i in range(len(str_num)):
        rotated = str_num[i:] + str_num[:i]
        rotations.append(int(rotated))
    
    return rotations


def is_circular_prime(n):
    # Check if all rotations are prime
    rotations = get_rotations(n)

    result = False;

    for i in range(len(rotations)):
        result = is_prime(rotations[i])
    
    return result
