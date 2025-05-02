# Target Zero

Given an integer n, return an array containing n unique integers such that they add up to 0.

### Input Format

First line contains an integers n.

### Constraints

None

### Output Format

Array integers summing upto 0.

### Sample Input

```
5
```

### Sample Output

```
-2 -1 0 1 2
```

### Explanation

Output should be in sorted order.

**Algorithm** :

Half the given number n.
Now iterate from i = 1 to n and add negative and positive of i, i.e i and -i in the result array.
If n is odd add zero into the result array.

For example:-
If n = 5, i.e n is odd then the result array will be [-2,-1, 0,1, 2].
If n = 4, i.e n is even then the result array will be [-2, -1, 1, 2].

### Time Complexity

```
O(n log(n))
```

### Space Complexity

```
O(n)
```
