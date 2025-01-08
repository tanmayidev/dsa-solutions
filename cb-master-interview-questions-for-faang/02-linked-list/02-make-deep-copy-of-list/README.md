# Make Deep Copy of List

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

<br>
Return a deep copy of the list.
<br>
The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

- val: an integer representing Node.val random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

### Input Format

```
single integer n (number of nodes) next n lines containing pairs of integers ( val and index )

NOTE :
index can be null also
```

### Constraints

```
1 <= n <= 1000
```

### Output Format

```
Two lines denoting : The old representation of list and the new representation of list as given in sample output . ( Make sure to print output exactly as in the sample output )
```

### Sample Input

```
5
6 4
4 0
8 4
9 1
6 2
```

### Sample Output

```
Old List: (6, 6) (4, 6) (8, 6) (9, 4) (6, 8)
Copied List: (6, 6) (4, 6) (8, 6) (9, 4) (6, 8)
```

### Explanation

**Algorithm** :

- Traverse the original list and clone the nodes as you go and place the cloned copy next to its original node.
- This new linked list is essentially an interweaving of original and cloned nodes.
- After the first step, you have already copied the ‘next’ pointers, now we copy the ‘random’ pointers and unweave the lists. - Iterate the list having both the new and old nodes intertwined with each other and use the original nodes’ random pointers to assign references to random pointers for cloned nodes.
- For eg. If B has a random pointer to A, this means B' has a random pointer to A'.
- You have successfully copied the nodes with random pointers, only thing is left is to decouple the original LinkedList from the Cloned one.
- Unweaving the linked lists

### Time Complexity
