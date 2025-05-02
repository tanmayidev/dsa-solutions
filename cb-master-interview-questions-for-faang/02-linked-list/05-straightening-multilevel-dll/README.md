# Straightening MultiLevel DLL

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

```java
class Node {
public int val;
public Node prev;
public Node next;
public Node child;
}
```

### Input Format

```
First line contains nodes of doubly linked
```

### Constraints

```
None
```

### Output Format

```
print list after Flatten
```

### Sample Input

```
[1,2,null,3]
```

### Sample Output

```
[1, 3, 2]
```

### Explanation

The input multilevel linked list is as follows:
1---2---NULL
|
3---NULL

**Algorithm** :

Using recursion

- we can use a pointer to find one node which contains child and call flatten function on both rest list and child list.
- It’s noted that we need to traverse child list for tail after flattened.
- Start form the head , move one step each time to the next node
- When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next, by doing this we merged the child chainback to the main thread
- Return to p and proceed until find next node with child.
- Repeat until reach null

### Time Complexity

```
O(N)
```
