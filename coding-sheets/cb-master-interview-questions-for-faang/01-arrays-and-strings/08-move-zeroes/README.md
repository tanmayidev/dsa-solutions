# Move Zeroes

Given an array A, write a function to move all 0's to the end of it while maintaining the relative order
of the non-zero elements.

### Input Format

First line contains integer n as size of array. next n lines contains a single integer as element of array.

### Constraints

**Note:** Do this in-place without making a copy of the array and Minimize the total number of operations.

### Output Format

Print the output Array.

### Sample Input

```
5
0
1
0
3
12
```

### Sample Output

```
1 3 12 0 0
```

### Time Complexity

```
O(n)
```

### Explanation

**Algorithm** : There can be many ways to solve this problem. Following is a simple and interesting way to solve this problem.

**Step 1 :** Initialize one variable n and vector ‘nums’ of integer type.(n is the number of elements to be pushed in the vector ‘nums’).

**Step 2 :** Make a function moveZeros and pass ‘nums’ as parameter (call by refrence).

**Step 3 :** Inside the function Initialize two variables l=0, m=0(means l and m pointer pointing at zero index)

**Step 4 :** Iterate the m pointer from left to right till m is less than size of vector nums. `(m < nums.size())`

**Step 5 :** Using switch case check if number is zero or any other number other than zero.

**Step 6 :** If nums[m] is 0 then increment the m pointer(m++) and come out of switch statement (use break).

**Step 7 :** If nums[m] is any number other than 0 then swap nums[l] and nums[m] increment the m and l pointer(l++,m++) and come out of switch statement (use break).

**Step 8 :** When (`m == nums.size()`) print all elements present in vector nums using pointer i=0 till `i < nums.size()`.
