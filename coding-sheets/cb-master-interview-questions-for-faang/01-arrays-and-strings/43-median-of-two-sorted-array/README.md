# Median of Two Sorted Array

There are two sorted arrays arr1 and arr2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume arr1 and arr2 cannot be both empty.

Note : if in case the median of the two sorted arrays is double type You have to print only integer part

### Input Format

```
Take Input N and M Next line contains N Integer and the Last line contains M Integer
```

### Constraints

```
N<10000
M<10000
```

### Output Format

```
print the median of the two sorted arrays
```

### Sample Input

```
2 1
1 3
2
```

### Sample Output

```
2
```

### Explanation

**Algorithm** :

The intuition here to use binary search is because we are given two sorted arrays.
The approach discussed here will work even when we have arrays of different sizes.

- How is median of two arrays calculated:-
- Intuition behind the approach:-

Let lenA be the size of array nums1 and lenB be the size of array nums2.

1. 1.Let aCount is the index at which array nums1 is partitioned and bCount is the index at which array nums2 is partitioned. aCount + bCount = mid i.e the left and right partition must equally divide the combined elements of the array to find the median. Where is mid = (lenA + lenB + 1) /

2. 2.Calculate max element of nums1 in left partition maxLeftA and min element in right partition minRightA. Similarly calculate maxLeftB and minRightB. Condition for perfect partition is when :-

```
maxLeftA <= minRightB && maxLeftB <= minRightA
```

3. maxLeftA > minRightB, aCount partition is too far to the right so reduce the search space to the left and move the aCount to left.

4. Else aCount is too far to the left so reduce the search space to the right and move aCount to right.

5. If Perfect partition is found:-

```
If combined size of both the arrays is even i.e lenA + lenB
is even
  Return Avg(max(maxLeftA, maxLeftB) + min(minRightA, minRightB)) as median.
Else
  Return max(maxLeftA, maxLeftB) as median.
```

Also the algorithm only involves iterating on the smaller of the two arrays, the function is called again so that nums1 is always the smaller array.

### Time Complexity

The algorithm has logarithmic time complexity as we have arrays already sorted and logn due to binary search.
