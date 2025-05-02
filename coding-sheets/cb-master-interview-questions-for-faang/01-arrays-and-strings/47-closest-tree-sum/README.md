# Closest Tree Sum

For the coding blocks placement test , kartik bhaiya decided to give students an array arr of n integers and an integer target. The task is to return the sum of three integers in arr such that their sum is closest to target.
Assume that each input would have exactly one solution.

### Input Format

```
First line contains integer n as size of array. Second line contains the target .Next n lines contains a single integer as element of array.
```

### Constraints

```
None
```

### Output Format

```
Print the sum that is closest to the target.
```

### Sample Input

```
4
1
-1
2
1
4
```

### Sample Output

```
2
```

### Explanation

### Time Complexity

```
Overall time complexity is O(n^2).
```

### **Algorithm** :

Here using two pointer approach we will solve the problem given problem and the steps to solve the problem are given below:

**Step 1**:

Initialize one variable n(int n) ,another variable target (int target) vector ‘num’ of integer type(vector num).(n is the number of elements to be pushed in the vector ‘num’ ).

**Step 2**:

Make a function threesumClosest(num,target) and pass ‘num’ (call by reference) and target as parameters and the function will return an integer type answer.<br>
`threesumClosest(num,target)` <br>
`Int threesumClosest(vector&num,int target)`

**Step 3**:
Inside the function sort ‘num’ and initialize two variables closeDiff=INT_MAX and close-sum.

**Step 4**:

Loop from i=0 till i equal to two less than size of vector num `(i=0; i < num.size()-2; i++)` and on every iteration increment i and inside the loop declare variables sum=0, and add num[i] to the
`sum(sum+=num[i])`,variable j=i+1 and k=num.size()-1 and add num[j] and num[k] to sum.

**Step 5**: Check till the condition j<k is satisfied and there can be many cases like:

- if(abs(sum-target)target) then subtract num[k] from sum, decrement k and add num[k] to the sum.
- if none of the above cases are true then come out of loop

**Step 6**:

When i===nums.size()-2 return close_sum.
