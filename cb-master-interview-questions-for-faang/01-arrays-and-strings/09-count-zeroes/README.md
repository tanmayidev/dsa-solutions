# Count Zeroes

Given a number n, find out number of trailing zeroes in n! in logarithmic time.

### Input Format

An integer n

### Constraints

n can go upto 2000

### Output Format

An integer denoting number of trailing zeroes

### Sample Input

```
5
```

### Sample Output

```
1
```

### Explanation

5! is 120, so there is one trailing zero.

**Algorithm** :

- The idea is to consider prime factorials of n!. Prime factors 2 and 5 are responsible for producing trailing zeros.

- Number of 2s is always more than or equal to 5 in a number. Hence we only need to calculate the number of 5s.

- The approach is to divide by 5 to remove single 5s, then divide by 25 to remove extra 5s and so on.

- So the approach boils down to below formulae :

  - Let f(n) give the number of trailing zeros in the base ten representation of n!.Then,

    ```
    f(n) = floor(n/5) + floor(n/25) + floor(n/125) + ... floor(n/5k)
    ```

- Where k = floor(log5n)

### Time Complexity

```
O(logn)
```
