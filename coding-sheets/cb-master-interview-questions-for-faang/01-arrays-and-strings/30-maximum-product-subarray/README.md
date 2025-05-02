# Maximum Product Subarray

Given an integer array arr, find the contiguous subarray within an array (containing at least one number) which has the largest product.

### Input Format

Take input N. Next line N contains elements of array, denoting the elements of array.

### Constraints

It is assured that the product does not exceed 10^16.

### Output Format

print largest product.

### Sample Input

```
15
1
2
2
1
2
3
4
5
6
1
2
3
4
5
7
```

### Sample Output

```
2419200
```

### Explanation

**Algorithm** : Maximum Product Subarray

Given an integer array arr find the contiguous subarray within an array (containing at least one number) which has the largest product.

Steps:

- Make a function maxProduct and pass array arr[ ] as parameter `maxProduct(int arr[ ])`.
- Inside the function
  - If array size is 1
  - Return arr[0]// due to the size of the array is 1
  - If array size is greater than 1.
    - Maximum ProductSubarray must be greater than equal to 0
  - Initialise variable `np = 1`, `pp = 1`,`max = Integer.MIN_VALUE`;
  - `hasZero = false`, `hasPos = false`;
  - np will keep track of negative product,
  - pp will keep track of positive product,
  - hasZero will keep track Whether 0 exist or not,
  - hasPos will keep track of the positive elements present in the array

4. loop from value `idx=1` to till `idx < n.length()`
   - `int i = arr[idx]`
   - Variable i can be positive or can be negative or can be zero
   - If variable i is positive
     - hasPos = true;// variable i is positive
     - pp \_= i;
     - if(np != 1) // np==1 denotes No negative element is encountered.
     - np \_= i;// update negative product np may be positive or negative
   - If np is negative npi is negative if np is positive npi is positive
     - If variable i is negative
     - temp = pp;
     - pp =max(1,npi) // npi may be positive or may be negative if np is negative then np \* i is positive if np is positive then npi will be negative in this condition pp will be 1.
     - np=tempi;// value of np
     - If variable i is zero
     - np=pp=1;
     - hasZero = true// 0 is present
     - After 1 iteration update max value
     - if(max < pp) max = pp;
   - if(max == 1) // may be variable i will be 0 or actual product will be 1, if actual
     - product is 1 means positive elements are definitelY
     - present In array arr if(hasPos)
     - return max; // hasPos is true positive elements arE present in array arr.
     - if(hasZero)
       - return 0; //haszero is true } < /n.length().
     - return max;//otherwise return max

### Time Complexity

O(N) where N is the Size of the array
