# Word Distance II

Given a list of words and two words, word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.

### Input Format

```
First line contains input N.
Next line contains N space separated String denoting the elements of the array.
Third line contains word1 and word2
```

### Constraints

```
None
```

### Output Format

```
Shortest Distance between word1 and word2
```

### Sample Input

```
5
practice makes perfect coding makes
makes makes
```

### Sample Output

```
3
```

### Explanation

**Algorithm** :

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

- word1 and word2 may be the same and they represent two individual words in the list.
- take two pointer p1 and p2
- initialize `p1 = -1` and `p2 = -1`

- answer is the shortest distance between these two words in the list
- if word1 is equal to word2,
  - loop from value `i = 1` to till `i < list.size()`
    - if word1 is equal to word at index i
      - update p1
    - else update ans
      - ans = min(ans, i-p)
- else (word distance - l)
  - loop from value `i = 1` to till `i < list.size()`
    - if word1 is equal to word at index i
      - update p1
    - if word2 is equal to word at index i
      - update p2
  - after each and every iteration
    - if `p1 != -1` and `p2 != -1`
      - update res
  - ans = min(ans, abs(p1 - p2))

### Time Complexity

```
O(N)
```
