# Word Distance 1

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list

Note : You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

### Input Format

First line contains input N. Next line contains N space separated String denoting the elements of the array. third line contains word1 and word2

### Constraints

None

### Output Format

Shortest Distance between word1 and word 2

### Sample Input

```
5
practice makes perfect coding makes
coding practice
```

### Sample Output

```
3
```

### Explanation

5
practice makes perfect coding makes
makes coding

Output:

```
1
```

**Algorithm** :

Given a list of words and two words, word1 and word2, take two pointer p1 and p2.
Initialize p1 = -1 and p2 = -1

Result :
The shortest distance between these two words in the list

Steps:

1. loop from value i=1 to till `i < list.size()`
   - If word1 is equal to word at index `i`
   - update p1
   - If word2 is equal to word at index `i`
   - update p2
2. After each and every iteration
   - If `p1 != -1` and `p2 != -1`
   - update res
3. res = min(res, abs(p1 - p2))

### Time Complexity

```
O(n)
```
