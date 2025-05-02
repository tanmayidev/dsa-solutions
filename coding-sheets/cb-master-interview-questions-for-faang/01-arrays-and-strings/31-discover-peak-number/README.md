# Discover Peak Number

A peak element is an element that is greater than its neighbors.
Given an input array arr, where arr[i] ≠ arr[i+1], find a peak element if exists return true else return false.
You may imagine that `arr[ -1 ] = arr[ n ] = -∞`.

### Input Format

A single integer, N, denoting the number of elements in array. Next line contains N integers, denoting the elements of array.

### Constraints

```
n < 1000000
```

### Output Format

if peak element is present print true else print false

### Sample Input

```
13
1 2 1 3 5 6 4 8 5 7 9 11 10
```

### Sample Output

```
true
```

### Explanation

**Algorithm** :

**Approach : 1 linear Search**
If for an element array[i], it is greater than both its neighbours, i.e.,
array[i] > array[i-1] and array[i] > array[i+1], return true;
If not possible
Return false;
**Time complexity**: O(N)

**Approach : 2 Divide and Conquer**
if(end>strat)
Return false;
if(start==end)
Return true;
Compare mid with the mid+1 element
If arr[mid ] > arr [mid+1]
we recur for the left half part
Else
we recur for the right half part
**Time complexity** : O(log(N))
