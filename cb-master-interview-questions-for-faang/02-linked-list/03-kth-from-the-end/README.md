# Kth from the End

Given a linked list, remove the k-th node from the end of list.

### Input Format

```
First line contains a single integer N denoting the size of the linked list.
Second line contains a single integer K denoting remove k-th node from the end of list
Third line contains N space separated integers denoting the elements of the linked list.
```

### Constraints

```
Note :Given k will always be valid.
```

### Output Format

```
Display updated linked list
```

### Sample Input

```
15
3
1 2 2 1 2 3 4 5 6 1 2 3 4 5 7
```

### Sample Output

```
1 2 2 1 2 3 4 5 6 1 2 3 5 7
```

### Explanation

Given a linked list, remove the n-th node from the end of list and return its head.

**Algorithm** :

Steps:

1. Take two pointers, first and second . Initially first and second will be point head. Now continue raising the second pointer until the second pointer points to the Nth node from the beginning first will point to the head of the linked list and second will point to the Nth node from the beginning.
2. Now keep increment both the pointers by one at the same time until the second is pointing to the last node of the linked list.
3. After the operations from the previous step, the first pointer should be pointing to the Nth node from the end by now. So, delete the node the first pointer is pointing to.

### Time Complexity

O(n), where n is the linkedlist size.
