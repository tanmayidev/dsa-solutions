# Lonely Element in a Sorted Array

Given a sorted array of integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Note: Your solution should run in O(log n) time and O(1) space.

### Input Format

First line contains integer n as size of array. Next line contains n element of array.

### Constraints

```
1 <= N <= 10^6
```

### Output Format

Print element that appears only once.

### Sample Input

```
9
1 1 2 3 3 4 4 8 8
```

### Sample Output

```
2
```

### Explanation

**Algorithm** :

You are given a sorted array consisting of only integers where every element appears exactly
twice except for one element which appears exactly once. Find this single element.

- Take two-pointers first (S) is at Index 0 and Second (E) is at Index a.length-1.
- Using Binary Search Method
- ```
    While(S<=E) {
      m = (S+E)/2;
      Check a[mid] is single or not
      If ( isSingle(a,m) ) return a[m] if m + 1 < a.length and
      if (a[m] is equal to a[m + 1]) {
        /_ if m is even and element at index m and index m+1 are Equal, that means Left Side of each element are in pairs .then we check Right Side /
      if (m % 2 == 0)
        s = m + 1;
      else e = m - 1; }
      else if (m >= 1 and a[m] is equal to a[m - 1]) {
        / if m is even and element at index m and index m-1 are Equal, that means Right Side of
        each element are in pairs .then we check Left Side _/

          if (m % 2 == 0)
            e = m - 1;
          else
           s = m + 1;
    }
  ```

- If Element is not found Than Return -1;
- Make isSingle Function Type of Boolean
  ```
  isSingle(int a[],m) {
    If m is 0 and a[0] != a[1]
     Return ture;
    If m is a.length - 1 and a[m] != a[m - 1]
      Return true;
    if a[m] != a[m + 1] and a[m] != a[m - 1]
      return true;
    return false;
  }
  ```

### Time Complexity

```
O(log(N))
```
