def is_fizz_buzz(arr):
    start = None

    # Find starting number
    for i, val in enumerate(arr):
        if isinstance(val, int):
            start = val - i
            break

    if start is None:
        return False

    for i in range(len(arr)):
        num = start + i

        if num % 15 == 0:
            expected = "FizzBuzz"
        elif num % 3 == 0:
            expected = "Fizz"
        elif num % 5 == 0:
            expected = "Buzz"
        else:
            expected = num

        if arr[i] != expected:
            return False

    return True