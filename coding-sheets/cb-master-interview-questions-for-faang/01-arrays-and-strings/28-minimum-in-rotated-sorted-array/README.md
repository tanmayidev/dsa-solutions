# Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
Find the minimum element.
You may assume no duplicate exists in the array.

### Input Format

First line contains an integers n i.e number of array elements. following line contains n integers representing array.

### Constraints

None

### Output Format

A single integer denoting minimum element.

### Sample Input

```
7
3 4 5 6 0 1 2
```

### Sample Output

```
0
```

### Explanation

**Minimum in Rotated Sorted Array (Modified Binary Searc) Intuition** :

- When an array is rotated, first a rotation point is to be found.
- Observation about rotation point :

  - All the elements to the left of the rotation point are greater than the first element
  - All the elements to the right of the rotation point are less than the first element

- This will give us two sorted arrays :

```
0 1 2 3 4 5

Array : 4 5 6 7 2 3
Array[0, 3] is the first sorted array
Array[4, 5] is the second sorted array
```

Where rotation point is index 4 with value 2 and that is the smallest value in the given array.

**Algorithm** :

Search Space : 0 to n-1 is the search space where l = 0 and r = n-1
Special Case : First check if the array is rotated or not. If the last element in the array is greater than or euqal to first that means the array is not rotated and the first element is the smallest element.

Find mid of the given array.
If mid -1 is greater than equal to 0 and arr[mid] is less than arr[mid - 1], that means mid is at the first element of the second sorted array as explained above. So arr[mid] is the smallest element of all, and this is the point of rotation.

Else if element arr[mid] is greater than the last element. So all the elements before mid will also be greater than last, so our search space is reduced to l = mid + 1 and r i.e., search is to be performed only at the right of the mid.

```
0 1 2 3 4 5
```

Array: 4 5 6 7 2 3

Here, mid = 2, arr[mid] = 6 > arr[n-1], so all elements in arr[0, mid] are greater than arr[n-1].

Else the search space is reduced to l and r = mid - 1.

### Time Complexity

Time Complexity:- O(Log n), same as binary search.

### Space Complexity

Space Complexity: - O(1).
