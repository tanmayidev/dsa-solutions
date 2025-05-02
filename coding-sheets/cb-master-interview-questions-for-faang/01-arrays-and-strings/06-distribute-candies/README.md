# Distribute Candies

Given an integer array with even length, where different numbers in this array represent different
kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Print the maximum number of kinds of candies the sister could gain.

### Input Format

The first line contains an integer N, which denotes the Size of Arrays.and then next line contains n space separated integers representing the values of Arrays

### Constraints

```
1 < N < 10,001
```

### Output Format

Print a Single Integer A which denotes kinds of candies the sister could gain.

### Sample Input

```
6
1 1 1 2 2 3 3
```

### Sample Output

```
3
```

### Explanation

**Algorithm** :
Algorithm: Here using unordered_map we will solve the problem given problem and the steps to solve the problem are given below:

**Step 1:** Initialize one variable n(int n) ,vector ‘arr’ of integer type(vector arr).(n is the number of elements to be pushed in the vector ‘arr’ ).

**Step 2:** Make a function distributeCandies(arr) and pass ‘arr’(call by reference) as parameter and the function will return an integer.
distributeCandies(arr) Int distributeCandies(vector& candies)

**Step 3:** Inside the function declare an unordered map ‘m’ of key of type int and value of type int and a variable count=0 initially.
unordered_map m

**Step 4:**

- Loop from i=0 till i less than size of vector candies `(i = 0; i < candies.size(); i++)` ,on every iteration increment i and inside the loop check whether the element has occured before or not and if the element has not occured before then at the key candies[i] in map ‘m’ put value equal to 1 and increment the count variable (count++), else if the element has occured before then increment the value by 1 at key candies[i] in the map m.

**Step 5:** Declare a variable ans(int ans) .When i==candies.size() and value of count is less than `candies.size()/2` then `ans=count` else `ans=candies.size()/2`.Return ans.

### Time Complexity

Overall time complexity is O(nlogn).
