# Sorting in Linear Time

Given an array having n elements representing balls of various colours like red, white or blue, sort them in-place so that balls of the same colour are adjacent, with the colours in the order red, white and blue.

To represent the colour red, white, and blue we will use the integers 0, 1, and 2 respectively.

Note:You are not suppose to use the sort function for this problem.

### Input Format

First line contains integer n as size of array. Next n lines contains a single integer as element of array.

### Constraints

None

### Output Format

Print the balls in order so that balls of same colour are adjacent.

### Sample Input

```
6
2 0 2 1 1 0
```

### Sample Output

```
0 0 1 1 2 2
```

### Explanation

**Algorithm** :

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

The aim is to sort the array in linear time.

**Steps**:

1. Take 3 pointers l, r and curr.
2. Set l and curr at index 0 and r at last index of the array.
3. l pointer will keep track of 0, r pointer will keep track of 2 and curr pointer will keep track of 1.
4. We will iterate over whole array and update the array after every iteration and follow the steps below.
   - if the element at curr index is 2 then swap the value of the array at the curr index and the value at index r and r decrease by 1
     - this swapping will place 2 at it right position.
   - if the element at curr index is 0 then swap the value of the array at the curr index and the value at index l and l increase by 1 also Increase curr by 1
     - this swapping will place 0 at it right position.
   - if the element at the curr index is 1 . 1 will place 0 at its right position. Curr increase by 1

### Time Complexity
