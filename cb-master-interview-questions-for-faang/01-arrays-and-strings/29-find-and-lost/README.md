# Find and Lost

Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Note:-
If the x is not found in the array, print -1

### Input Format

The first line contains two integers n and x. The second line contains n spaced integers.

### Constraints

```
1 < n < 10^8

-1 < arr[i] < 10^9
```

### Output Format

Print index of the first and last occurrences of the number x with a space in between.

### Sample Input

```
9 7
1 3 5 5 5 5 7 123 125
```

### Sample Output

```
6 6
```

### Explanation

**Algorithm** :

Given an array of integers arr sorted in ascending order, find the starting and ending position of a given target value.

#### Approach 1 : Linear Search

1. Run a for loop and for i=0 to n-1
2. Take first = -1 and last = -1
3. When we find element first time then we update first = i
4. We always update last = i whenever we find the element
5. We print first and last

Time Complexity : O(N)

#### Approach 2 : Binary Search - O(log(N))

1. For the first occurrence of a number

- Compare x with the middle element
- If x matches with middle element, udpate FirstOccurrence and we recur for the left half part
- If x is greater than the mid element, then x can only lie in right half subarray after the mid element
- So we recur for right half, If(x is smaller) recur for the left half

2. For the last occurrence of a number

- Compare x with the middle element
- If x matches with middle element, udpate lastOccurrence and we recur for the right half part
- If x is greater than the mid element, then x can only lie in right half subarray after the mid element
- So we recur for right half, If (x is smaller) recur for the left half

### Time Complexity
