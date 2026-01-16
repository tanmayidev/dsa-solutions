import math

def is_integer_hypotenuse(a, b):
    hypotenuse = math.sqrt(a * a + b * b)
    return hypotenuse.is_integer()
