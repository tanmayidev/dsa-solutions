# Arrange Odd Even Linked List

We are Given a singly linked list, group all odd nodes together followed by the even nodes. Here we are talking about the node number and not the value in the nodes.
<br>
Note: <br>

- You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
- The relative order inside both the even and odd groups should remain as it was in the input.
- The first node is considered odd, the second node even and so on

### Input Format

```
First line contains the number of nodes n. Next line contains the n node numbers.
```

### Constraints

```
1 <= Length of linked list <= 10^4
```

### Output Format

```
Print the original list and the modified list after Grouping all odd nodes together followed by the even nodes.
```

### Sample Input

```
10
1 2 3 4 5 6 7 8 9 10
```

### Sample Output

```
Original List: 1 2 3 4 5 6 7 8 9 10
Modified List: 1 3 5 7 9 2 4 6 8 10
```

### Explanation

Arrange Odd Even linked list

### Time Complexity

Overall time complexity is O(n).Where n is the number of nodes in the linked list.

### **Algorithm** :

Here the task is to group all odd positioned nodes together followed by the even positioned nodes.This can be done by following steps:

Step 1: <br>
Inside the function OddEvenList which will return the head of the modified linked list pass head of the given linked list as parameter . <br>

ListNode* OddEvenList (ListNode* head)

Step 2: <br>
If the head is equal to NULL return NULL from the function .

Step 3: <br>
If head is not NULL then create pointers oddhead, oddtail, evenhead and eventail initially pointing to NULL , temp pointer equal to head and a variable is_odd of boolean type equal to 1
initially.

Step 4: <br>
Traverse through the whole linkedlist till temp!=NULL. For the odd position if oddhead is equal to NULL then oddhead= oddtail = temp .Else oddtail->next=temp and oddtail =temp.Then update the temp pointer as temp =temp->next and oddtail->next pointing to NULL.

Step 5: <br>
For the Even position if evenhead is equal to NULL then evenhead=eventail=temp. Else eventail->next =temp and eventail=temp.Then update the temp pointer as temp =temp->next and
eventail->next pointing to NULL.

Step 6: <br>
After one iteration update isodd = !isodd and when temp is equal to NULL update oddtail-> next=evenhead.(group odd positioned nodes followed by even positioned nodes). And return oddhead.
