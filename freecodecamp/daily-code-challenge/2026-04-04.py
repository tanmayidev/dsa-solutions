def is_valid_equation(equation: str) -> bool:
    left, right = equation.split("=")
    target = int(right.strip())

    tokens = left.strip().split()

    # Step 1: handle * and /
    stack = [int(tokens[0])]

    i = 1
    while i < len(tokens):
        operator = tokens[i]
        num = int(tokens[i + 1])

        if operator == "*":
            stack[-1] *= num
        elif operator == "/":
            stack[-1] /= num
        else:
            stack.append(operator)
            stack.append(num)

        i += 2

    # Step 2: handle + and -
    result = stack[0]
    i = 1
    while i < len(stack):
        operator = stack[i]
        num = stack[i + 1]

        if operator == "+":
            result += num
        else:
            result -= num

        i += 2

    return result == target