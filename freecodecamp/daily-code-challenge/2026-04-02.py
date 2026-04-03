def capitalize_fibonacci(s):
    # Generate Fibonacci indices up to len(s)
    fib = [0, 1]
    while fib[-1] < len(s):
        fib.append(fib[-1] + fib[-2])
    
    fib_set = set(fib)

    result = []
    
    for i, ch in enumerate(s):
        if not ch.isalpha():
            result.append(ch)
        elif i in fib_set:
            result.append(ch.upper())
        else:
            result.append(ch.lower())

    return ''.join(result)