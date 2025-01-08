# Product of Any Array Except Self

Given an array arr of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of arr except arr[i].

### Input Format

```
First line contains integer N as size of array.
Next line contains a N integer as element of array.
```

### Constraints

```
arr[i]<=10000000
```

### Output Format

```
print output array
```

### Sample Input

```
4
1 2 3 4
```

### Sample Output

```
24 12 8 6
```

### Explanation

In this problem we are not allowed to use division(/) operator.

**Algorithm** :

1. Initialize two empty arrays, L and R where for a given index i, L[i] would contain the product of all the numbers to the left of i and R[i] would contain the product of all the numbers to the right of i.

2. We would need two different loops to fill in values for the two arrays. For the array L, L[0] would be 1 since there are no elements to the left of the first element. For the rest of the elements, we simply use `L[i] = L[i - 1] \_ nums[i - 1]`, Here L[i] represents the product of all the elements to the left of element at index i.

3. For the other array R, we do the same thing but in reverse i.e. we start with the initial R[length - 1] = 1 where Length is the number of elements in the array, and keep updating R[i] in reverse by using, `R[i] = R[i + 1] \_ nums[i + 1]`, Here R[i] represents the product of all the elements to the right of element at index i.

4. Once we have the two arrays set up properly, we simply iterate over the input array one element at a time, and for each element at index i, we find the product except self as :- `L[i] \* R[i].`

### Time Complexity

O(N) where N represents the number of elements in the input array. <br>
We use one iteration to construct the array L, one to construct the array R and one last to construct the answer array using L and R.

### Space Complexity

O(N) as we are using two intermediate arrays L and R.
