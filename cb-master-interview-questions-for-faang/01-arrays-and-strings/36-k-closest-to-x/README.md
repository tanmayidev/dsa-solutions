# K Closest to X

Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

### Input Format

```
First line contains input N
Next line contains N space separated integers denoting the elements of the array
The third line contains a two integer k and x
```

### Constraints

```
N < 100000
k < N
Absolute value of elements in the array and x will not exceed 10000
```

### Output Format

```
Print K closest number
```

### Sample Input

```
5
1 2 3 4 5
4 3
```

### Sample Output

```
1 2 3 4
```

### Explanation

Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

#### Algorithm

**Approach 1** :

Note :<br>
If the target x is less or equal than the first element in the sorted array, the first k elements are the result.

Note :<br>
Similarly, if the target x is more or equal than the last element in the sorted array, the last k elements are the result. <br>
otherwise, The idea is that we can take advantage of the fact the array is already sorted. We're looking for a region of length k which minimizes sum of the absolute difference between all its elements and x. We can use a sliding window technique. Each time we slide the window forward we undo the contribution from the element we removed and add in the new contribution from the next element.

#### Time Complexity

```
O(N)
```

**Approach 2** :

- If the target x is less or equal than the first element in the sorted array, the first k elements are the result.
- Similarly, if the target x is more or equal than the last element in the sorted array, the last k elements are the result.
- Otherwise, we can use binary search to find the index of the element, which is equal (when this list has x) or greater than x (when this list does not have it).
- Then set low to its left k-1 position, and high to the right k-1 position of this index as a start.
- The desired k numbers must in this rang [index-k-1, index+k-1].
- So we can shrink this range to get the result using these rules.
- If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index.
- If high reaches to the highest index arr.length()-1 or it is nearer to x than the low element, increase the lowindex.
- The looping ends when there are exactly k elements in [low, high], the subList of which is the result.

#### Time Complexity

```
O(Logn + k)
```
