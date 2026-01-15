"""
Array Swap
Given an array with two values, return an array with the values swapped.

For example, given ["A", "B"] return ["B", "A"].

Test Cases : 
1. array_swap(["A", "B"]) should return ["B", "A"].
2. array_swap([25, 20]) should return [20, 25].
3. array_swap([True, False]) should return [False, True].
4. array_swap(["1", 1]) should return [1, "1"].

"""

def array_swap(arr):
    arr[0], arr[1] = arr[1], arr[0]
    return arr
