# First Missing Positive Number

Given an array of integers, your task is to find out the first missing positive integer.

### Input Format

```
First line contains a single integer denoting the size of the array.The next line contains N integers
```

### Constraints

```
N <= 100000
```

### Output Format

```
Print a single line denoting the first missing element
```

### Sample Input

```
4
3 4 -1 1
```

### Sample Output

```
2
```

### Explanation

**Algorithm** :

- We will first need to assume that all the elements present in the array of size n are between 1- n.
- Here our answer will be n+1 as it is the only smallest positive number. Once established this relation we will iterate over the whole array and will decrease our ans by 1 everytime we find an element which is <=0 or greater than n.
- Also while traversing the whole array if the element is within the boundary i.e `0 < element <= n` we will keep this element at it’s right place by simply doing swap(a[i],a[a[i]-1]). ///// a[i]-1 because of 0-based indexing If our element is out of the boundary we will then at the current index put the last element since we are decrementing our ans/size.
- Atlast we return our ans;

### Time Complexity

O(N)

#### Space Complexity:

O(1)
