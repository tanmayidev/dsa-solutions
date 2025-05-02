# Candy Distribution

Given N students in a line and their marks, you have to distribute candies in such a way that every child must get atleast one candy and children with strictly higher marks than their neighbours get more candies than them.
You have to tell what is the minimum number of candies needed for this task.

### Input Format

```
First line contains a single element N. Next line contains N elements denoting the marks of N children in order.
```

### Constraints

```
N <= 100000
0 <= Marks < 1000
```

### Output Format

```
Print a single line containing minimum number of candies required to fulfil the above conditions.
```

### Sample Input

```
3
1 2 2
```

### Sample Output

```
4
```

### Explanation

Children will get 1,2,1 candies respectively.

### **Algorithm** :

One thing important to note in this question is that the student will get more candies than his neighbours only if his marks are greater than his neighbours. Which also means that if a neighbour has the same marks as his we can give him fewer candies.
<br>

First we will make another array s and initialise all elements to 1 where i’th index represents the number of candies that i’th child will get. Then we will traverse from index i=1 to i=n-1 and check if the current student’s marks are greater than its left neighbour. If the marks are greater than it’s left neighbour we will simply do s[i]=1+s[i-1]. Here s is that array which contains the candy information. This way we ensure that the candies one is getting is greater than it’s left neighbour if it’s marks are greater.
<br>

Similarly we will traverse from i=n-2 to i=0 checking only the right elements and operating s[i]=1+s[i+1] if the current child’s marks are greater than it’s right neighbour. Doing these 2 passes will ensure that the required conditions are met. Atlast we will sum over the elements of our candy array s and return the result.

### Time Complexity

```
O(N)
```
