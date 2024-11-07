# Longest Common Prefix

### Input Format

```

```

### Constraints

```

```

### Output Format

```

```

### Sample Input

```

```

### Sample Output

```

```

### Explanation

**Algorithm - First Approach** :

1. Find the string having the minimum length. Let this length be L.
2. Perform a binary search on any one string (from the input array of strings). Let us take the first string and do a binary search on the characters from the index – 0 to L-1.
3. Initially, take low = 0 and high = L-1 and divide the string into two halves – left (low to mid) and right (mid+1 to high).
4. Check whether all the characters in the left half is present at the corresponding indices (low to mid) of all the strings or not. If it is present then we append this half to our prefix string and we look in the right half in a hope to find a longer prefix.(It is guaranteed that a common prefix string is there.)
5. Otherwise, if all the characters in the left half is not present at the corresponding indices (low to mid) in all the strings, then we need not look at the right half as there is some character(s) in the left half itself which is not a part of the longest prefix string. So we indeed look at the left half in a hope to find a common prefix string. (It may be possible that we don’t find any common prefix string).

- Time complexity is O(NM log M)
  - M = Length of the largest string and N = Size of Array

**Algorithm - Second Approach** :

1. Insert all the words one by one in the trie. After inserting we perform a walk on the trie
2. In this walk, go deeper until we find a node having more than 1 children(branching occurs) or 0 children (one of the string gets exhausted).This is because the characters (nodes in trie) which are present in the longest common prefix must be the single child of its parent, i.e- there should not be branching in any of these nodes.

- Time Complexity : O (N\*M)
