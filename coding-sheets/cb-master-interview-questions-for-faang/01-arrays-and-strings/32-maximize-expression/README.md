# Maximize Expression

Dobby is bored since he has no new problems to solve.So,he thought of a new problem himself.The problem is :
Given two arrays of integers with equal lengths,find the maximum value of: `|a1[i] - a1[j]| + |a2[i] - a2[j]| + |i - j|` where 1<=i , j<=n where n is the length of the arrays.

### Input Format

```
The first line contains an integer n - the size of the arrays.
Next line contains n integers - elements of array a1
Last line contains n integers - elements of array a2
```

### Constraints

```
1 <= n <= 10^5
```

### Output Format

Print a single integer equal to the maximum value of the expression given in the question

### Sample Input

```
3
1 2 3
4 5 6
```

### Sample Output

```
6
```

### Explanation

The maximum value is 6 corresponding to i =1 and j=3.

### Time Complexity
