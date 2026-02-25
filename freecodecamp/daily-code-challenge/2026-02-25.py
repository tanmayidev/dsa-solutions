def find_differences(arr):
    result = []
    
    for i in range(len(arr) - 1):
        result.append(arr[i + 1] - arr[i])
    
    result.append(0)  # last element
    
    return result
