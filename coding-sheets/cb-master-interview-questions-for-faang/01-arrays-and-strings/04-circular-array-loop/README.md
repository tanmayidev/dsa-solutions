# Circular Array Loop

You are given an array of positive and negative integers. If a number k at an index is positive, then
move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is
circular, you may assume that the last element's next element is the first element, and the first
element's previous element is the last element.

Determine if there is a loop (or a cycle) in array. A cycle must start and end at the same index and
the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other
words, a cycle must not consist of both forward and backward movements. Print 1 if cycle present
else print 0.

### Input Format

First Line Contains single integer n Second line contains n space separated integers

### Constraints

```
1 < =n <= 1e6
-1000 <= Ai <= 1000
```

### Output Format

```
single digit 1 or 0
```

### Sample Input

```
5
2 -1 1 2 2
```

### Sample Output

```
1
```

### Explanation

**Algorithm** :

- Here in this question , we can use the famous technique to detect a **floyd cycle which is called tortoise and hare algorithm** .
- In this algorithm we basically use two pointers where one pointer
  denotes Slow one and the other denotes fast one.
- So the basic gist of this technique is that fast
  pointer moves forward two steps at a time and the slow one moves 1 step at a time and they both
  start simultaneously so when they meet at a point ,that point denotes the origin of cycle .

- Here in this array we can use this technique to move between indices and once both the pointer come on same index we can say that a cycle exist.

- Make sure that the cycle may exist in either only positive elements or only negative elements since we have to go in a single direction.

### Time Complexity
