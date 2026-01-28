def flatten(arr):
    result = []

    def helper(items):
        for item in items:
            if isinstance(item, list):
                helper(item)
            else:
                result.append(item)

    helper(arr)
    return result
