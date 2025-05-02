# Smaller Numbers after Self 1

You are given an integer array arr and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of arr[i].

### Input Format

```
First line of the input contains an integer N denoting the size of the array, and the Next N line contains integers.
```

### Constraints

```
None
```

### Output Format

```
print counts array
```

### Sample Input

```
6
1
4
2
3
6
2
```

### Sample Output

```
0 3 0 1 1 0
```

### Explanation

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

**Algorithm** :

1. Create a Array Type of Pair

- which stores elements of the array and index of that elements
- create static array int ans[] of a size N

2. Use merge sort algorithm

3. function merger_pair(pair ar[], int start, int end)

- Pair ar divide in two-part recursively
- The first pair will be f and the second pair will be s.
- if the size of the pair will be 1, it is the base case of my function

```
if (start >= end)
  return

int m = (start + end) / 2;
pair f[] = mergeSort(ar, start, m);
pair s[] = mergeSort(ar, m + 1, end);
merge(f[], s[]);
```

- Merge f pair and s pair

4. Use merge two sorted array algorithm for (merge f pair and s pair) c will keep track of count of smaller numbers after self first time f[0] and s[1] will be merge

```
if (f[0] > s[1])
  // may be smaller numbers after self
  c++
else
  // current number is greater
  the current value of c is my answer
```

**Merge Algorithm**:

1. Introduce read-indices i, j to traverse pair f and pair s, accordingly. Introduce write-index k to store the position of the first free cell in the resulting array. By default i = j = k = 0

2. At each step : if both indices are in range (i < m and j < n), choose minimum of (f[i], s[j]) and write it to a[k]. Otherwise go to step 4

3. Increase k and index of the array, algorithm located minimal value at, by one. Repeat step 2.

4. Copy the rest values from the array, which index is still in ranger, to the resulting pair.

```
// Pseudocode

while (i < f.length && j < s.length) {
  if (f[i].data <= s[j].data) {
    ans[f[i].i] += count;
    a[k++] = f[i++];
  } else {
    count++;
    a[k++] = s[j++];
  }
}

if i is equal to f.length
  copy the rest values from the s[],
  a[k++] = s[j++]
if j is equal to s.length
  copy the rest values from the s[],
  ans[f[i].i] += count;
  a[k++] = f[i++]

```

### Time Complexity

N(log(N))
