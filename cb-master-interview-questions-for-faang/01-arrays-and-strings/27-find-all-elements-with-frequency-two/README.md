# Find All Elements with Frequency Two

Given an array of integers, 1 ≤ arr[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
\_\_ Answer must be sorted

### Input Format

```
1.it reads a number N.
2.Take Another N numbers as an input and store them in an Array.
```

### Constraints

```
Time Complexity O(N)
```

### Output Format

```
print all the elements that appear twice in this array
```

### Sample Input

```
8
4 3 2 7 8 2 3 1
```

### Sample Output

```
[2, 3]
```

### Explanation

Given an array of integers, `1 <= a[i] <= n` (n = size of array), some elements appear twice and other appear once.

Find all the elements that appear twice in this array.

**Algorithm** :

1. Make a function `findDuplications` and pass array a[] as parameter `findDuplicates(int a[])`
2. Create ArrayList list, inside the Function
   - list contains duplicate elements
   - arraylist allocate memeory dynamically in java
3. The array 'a' will contains number in rang from 1 to n and all of them will be positive
4. So to find out the duplicate elements, loop from value i=1 to `i < a.length()` and inside the loop take its absolute value of a[i] and if the abs(a[i] -1)th element is positive, it indicates that the element has not encountered before, else if negative the element has been encountered before . Add the absolute value of the current element a[i] in the arraylist 'list'.
5. Print arraylist list

   ```
   //pseudocode

   int temp = Math.abs(a[i]);
   if (a[temp - 1] *= -1) {
     a[temp - 1] *= -1;
   } else {
     list.add(temp);
   }

   ```

### Time Complexity

O(N) where N is the Size of the array
