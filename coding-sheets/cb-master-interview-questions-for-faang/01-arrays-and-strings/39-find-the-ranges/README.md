# Find the Ranges

Dobby is bored since he has no new problems to solve.So,he thought of a new problem himself. The problem is :

Given a sorted integer array without duplicates , print the continuous range of elements present in the array. The starting and ending element of the range must be separated by ->.
The range may start from any number .

For eg. if the array is `[0 , 1 , 2 , 6 , 7]` , you should print `0->2 6->7`.

### Input Format

```
The first line contains an integer n-the size of the array.
Next line contains n integers-elements of array
```

### Constraints

```
1 <= n <= 10^5
```

### Output Format

```
Print the ranges as a space separated string on a single line.
```

### Sample Input

```
5
0 1 2 6 7
```

### Sample Output

```
0->2 6->7
```

### Explanation

The ranges are 0-2(from 1st index(1-based indexing) to 3rd index) and 6-7 (from 4th to 5th index).

**Algorithm** :

### Time Complexity
