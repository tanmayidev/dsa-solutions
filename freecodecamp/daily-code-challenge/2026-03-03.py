def integer_cuberoot_floor(x):
    low, high = -10**6, 10**6  # safe bounds for this problem
    
    while low <= high:
        mid = (low + high) // 2
        cube = mid ** 3
        
        if cube == x:
            return mid
        elif cube < x:
            low = mid + 1
        else:
            high = mid - 1
    
    return high  # largest integer where mid^3 <= x


def integer_cuberoot_ceil(x):
    root = integer_cuberoot_floor(x)
    if root ** 3 == x:
        return root
    return root + 1


def count_perfect_cubes(a, b):
    low = min(a, b)
    high = max(a, b)

    start = integer_cuberoot_ceil(low)
    end = integer_cuberoot_floor(high)

    return max(0, end - start + 1)
