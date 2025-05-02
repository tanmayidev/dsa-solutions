# Search in Rotated Sorted Array

Given an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.

Note:You may assume no duplicate exists in the array.

### Input Format

First line contains size of Array. Second line contains n elements of Array. Third line contains target elements.

### Constraints

Your algorithm's runtime complexity must be in the order of O(log n).

### Output Format

Print the index of element if found , otherwise print -1.

### Sample Input

```
7
4 5 6 7 0 1 2
0
```

### Sample Output

```
4
```

### Explanation

**Algorithm** :

Using the concept of binary search we can solve the problem in the following steps:

Step 1: Initialize one variable n (int n),vector ‘nums’ of integer type(vector nums).(n is the number of elements to be pushed in the vector ‘nums’) and a variable ‘target’.

Step 2: Make a function search and pass ‘nums’ and target as parameters. Ie,
search(nums,target) Int search(vector &nums,int target)

Step 3: Inside the function Initialize variable n=nums.size(),l=0,r=n-1 and loop till l<=r.

Step 4: Initialize a variable mid=(l+r)/2 inside the loop and check if nums[mid]==target then return mid.

Step 5: Else if element at index mid is greater than the last element and check if target is less than nums[0] or target is greater than nums[mid] then put l=mid+1,else put r=mid-1.

Step 6: Else if target is greater than nums[n-1] or target is less than nums[mid] put r=mid-1 else put l=mid+1.

Step 7: When l>r means the element is not present so return -1 from the function.

### Time Complexity

Time complexity of this solution is O(logn).
