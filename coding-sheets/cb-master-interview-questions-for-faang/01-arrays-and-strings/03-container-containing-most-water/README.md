# Container Containing Most Water

In Coding blocks test Kartik bhaiya gave students an array of n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

The task is to find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

### Input Format

First line contains integer n as size of array. Next n lines contains a single integer as elements of array.

### Constraints

```
n >= 2
```

### Output Format

Output maximum water the container contains.

### Sample Input

```
9
1 8 6 2 5 4 8 3 7
```

### Sample Output

```
49
```

### Explanation

**Algorithm**: Here using two pointer approach we will solve the problem given problem and the steps to solve the problem are given below:

- Step 1: Initialize one variable n(int n) ,vector ‘v’ of integer type(vector v).(n is the number of elements to be pushed in the vector ‘v’ ).

- Step 2: Make a function maxArea(v) and pass ‘v’ (call by reference) as parameter and the function will return an integer type answer.
  `maxArea(v)`
  `Int maxArea(vector& height)`

- Step 3: Inside the function declare variables n=height.size()-1 ,i=0,ans=0 initially.

- Step 4: Loop from i=0 till i is less than n and inside the loop update the ans variable equal to maximum of variable ans and area of the rectangle (length=(n-i) and breadth=min(height[i],height[n])) covered between variables i and n ((n-i)\*min(height[i],height[n])).

- Step 5: Check if height[i] is less than height[n] then increment i by 1 else decrement n by 1.

- Step 6: If i becomes greater or equal to n return ans which is the required answer.

### Time Complexity :

Overall time complexity is `O(n)`.
