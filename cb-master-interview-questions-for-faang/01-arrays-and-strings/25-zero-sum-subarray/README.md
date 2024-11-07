# Zero Sum Subarray

You are given an array arr of size N. You need to print the total count of sub-arrays having their sum equal to 0

### Input Format

```
First line of the input contains an integer T denoting the number of test cases
For each test case :
Line 1 : N the size of Array
Line 2 : N elements for Array
```

### Constraints

```
1 <= T <= 100
1 <= N <= 10^6
-10^10 <= Ai <= 10^10
```

### Output Format

```
For each test case, in a new line, print the total number of subarrays whose sum is equal to 0.
```

### Sample Input

```
1
1
0
```

### Sample Output

```
1
```

### Explanation

**Algorithm** :

1. Make a function Count and pass array a[] as parameter `Count(int a[])`
2. Create Array `pr[]` of Size N, inside the Function Pr will be store subArray sum at every Index corresponding to a[]
   ```
     pr[0] = a[0]
   ```
3. Create HashMap m, inside the Function
   - Key of map m denote subarray sum and value of map m denote Number of Zero sum subarrays
   - Initialize map m
   ```
   m.put(0, 1);  // 0 denote initial subarray sum and 1 denote number of zero sum subarrays is 0 value of map m is M, Number of zero sum subarrays is 1 to M-1
   if(m.containsKey(a[0]))
     m.put(a[0], 2); // increase by 1 number of zeor sum subarrays
   else
     m.put(a[0], 1); // update subarrays sum and number of zero sum subarrays
   ```
4. Loop value `i = 1` to till `i < n.length()`
   ```
   // Inside the loop
   pr[i] = pr[i - 1] + a[i]; // Subarray sum at index 0 to index i
   f (m.containsKey(pr[i]))  // this condition will be true if pr[i] is 0
     m.put(pr[i], m.get(pr[i] + 1)); // increase by 1 number of zero sum subarrays
   else
     m.put(pr[i], 1);  // 1 denote number of zero sum subarrays
   </n.length()
   ```
5. C will keep track of number of zeor sum subarrays
   - Initial `c = 0;`
6. Loop on `keySet` of map
   ```
   for (int i : m.keySet()) // get value corresponding key
   int n = m.get(i);
   c += (n(n - 1))   // n(n-1) denote total number of zero subarray sum corresponding value n
   ```
7. return c

### Time Complexity

```
O(N) where N is the Size of the array
```
