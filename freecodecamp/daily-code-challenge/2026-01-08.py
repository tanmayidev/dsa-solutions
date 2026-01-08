"""
Sorted Array?
Given an array of numbers, determine if the numbers are sorted in ascending order, descending order, or neither.

If the given array is:
- In ascending order (lowest to highest), return "Ascending".
- In descending order (highest to lowest), return "Descending".
- Not sorted in ascending or descending order, return "Not sorted".

Test Cases
1. is_sorted([1, 2, 3, 4, 5]) should return "Ascending".
2. is_sorted([10, 8, 6, 4, 2]) should return "Descending".
3. is_sorted([1, 3, 2, 4, 5]) should return "Not sorted".
4. is_sorted([3.14, 2.71, 1.61, 0.57]) should return "Descending".
5. is_sorted([12.3, 23.4, 34.5, 45.6, 56.7, 67.8, 78.9]) should return "Ascending".
6. is_sorted([0.4, 0.5, 0.3]) should return "Not sorted".

"""

def is_sorted(arr):
    isAsc = True
    isDesc = True
    
    n = len(arr)
    
    if n <= 1:
        return "Ascending"
    
    for i in range(0, n-1):
        if arr[i] > arr[i+1]:
            isAsc = False
        
        if arr[i] < arr[i+1]:
            isDesc = False
    
    if isAsc:
        return "Ascending"
    elif isDesc:
        return "Descending"
    else:
        return "Not sorted"
