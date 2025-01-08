# Diagonal Traversal

Given an array of M x N elements (M rows, N columns), return all elements of the array in diagonal order .

### Input Format

```
Two integers M(row) and N(column) and Second line contains N*M space separated integers denoting the elements of Array.
```

### Constraints

```
The total number of elements of the given array will not exceed 10,000.
```

### Output Format

```
display Diagonal
```

### Sample Input

```
3 3
1 2 3 4 5 6 7 8 9
```

### Sample Output

```
1 2 4 7 5 3 6 8 9
```

### Explanation

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

**Algorithm** :

1. Initialize a result array that we will eventually return.
2. We would have an outer loop that will go over each of the diagonals one by one. As mentioned before, the elements in the first row and the last column would actually be the heads of their corresponding diagonals.
3. We then have an inner while loop that iterates over all the elements in the diagonal. We can calculate the number of elements in the corresponding diagonal by doing some math but we can simply iterate until one of the indices goes out of bounds.

The first row and the last column in this problem would serve as the starting point for the corresponding diagonal. Given an element inside a diagonal, say, [i, j] we can either go up the diagonal by going one row up and one column ahead i.e. [i - 1, j + 1] or, we can go down the diagonal by going one row down and one column to the left i.e. [i + 1, j - 1]

**Note**: that this applies to diagonals that go from right to left only.

4. For each diagonal we will need a new list or dynamic array like data structure since we don't know what size to allocate. Again, we can do some math and calculate the size of that particular diagonal and allocate memory; but it's not necessary for this explanation.
5. For odd numbered diagonals, we simply need to add the elements in our intermediary array, in reverse order to the final result array.

### Time Complexity

```
O(N* M)
```
