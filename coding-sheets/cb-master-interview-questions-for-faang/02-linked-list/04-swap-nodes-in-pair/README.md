# Swap Nodes in Pair

Given a linked list, swap every two adjacent nodes and print linked list <br>
note: You may not modify the values in the list's nodes, only nodes itself may be changed.

### Input Format

```
First line contains a single integer N denoting the size of the linked list.
Second line contains N space separated integers denoting the elements of the linked list.
```

### Constraints

```
None
```

### Output Format

```
First-line display an original linked list Second line display the linked list after swapping pairwise nodes.
```

### Sample Input

```
5
1 2 3 4 5
```

### Sample Output

```
1 -> 2 -> 3 -> 4 -> 5 ->
2 -> 1 -> 4 -> 3 -> 5 ->
```

### Explanation

**Algorithm** :

Algorithm: The above problem of swapping nodes in a pair can be solved using following algorithm whose steps are as below:

Step 1: Take linkedlist as input and pass it to a function namely ‘Swap_nodes’.

Step 2: Inside the function using recursive method swap two nodes pairwise.

i) Evertime we compare two nodes and keep on swapping them with the help of recursive function Swap_nodes() till either node is equal to null or next of node equal to null (node == null || node.next == null) which is the base case of the function.This base case will help us to avoid Null pointer Exception.
ii) The base case will return the node.

return node;

Step 3: On reaching the last two nodes of the linkedlist we will interchange the link that is pointing from secondlast element to last element, to point it in reverse direction.

Step 4: Print the linked list which is the desired output.

#### Pseudocode:

Swapnodes(Node node)
if (node == null || node.next == null) // Base Case
return node;
ListNode swap = Swapnodes(node.next.next);
ListNode another = node.next;
another.next = node;
node.next = swap;
return another;

### Time Complexity

O(n), where n is the linkedlist size.
