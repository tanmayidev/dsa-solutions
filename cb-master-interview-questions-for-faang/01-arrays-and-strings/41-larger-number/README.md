# Larger Number

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

### Input Format

```
Take input N
```

### Constraints

```
None
```

### Output Format

```
print result
```

### Sample Input

```
12
```

### Sample Output

```
21
```

### Explanation

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

**Algorithm** :

1. Take array of size 32
2. Abstract every digit from right side of N and Fill array from right to left
3. Take two pointer s and e Set s at = 32 - no of digit and e at = 31
4. Scan arr from right to left, find the first element that is less than its previous one.
   - If array is sorted in decreasing Order
   - return -1
   - Else
   - We need to find the first pair of two successive numbers a[e] and a[e-1] from the right
   - arr[e] > arr[e-1]
   - Int pos = e-1, int pos1 =e
   - Scan at e to arr.length()-1 if (arr [e]>arr[pos] and arr[e]
     - Update pos1
   - Swap element of array at index pos and pos1
   - Sort element of array from (pos1 + 1) to 31
   - if(32-s>=10)
     - Return -1;
   - Else
     - form_num from array (For example arr [ ]= {2 , 5, 6} ---> in number form 256)
     - return number;

### Time Complexity

```
O(1)
```

### Example

1. 1.Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.

2. Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976′′, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.

3. Swap the above found two digits, we get 536974

4. Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
