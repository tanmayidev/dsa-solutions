def is_flat(arr):
    for item in arr:
        if isinstance(item, list):
            return False
    return True
