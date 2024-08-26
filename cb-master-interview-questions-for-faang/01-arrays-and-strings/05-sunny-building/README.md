# Sunny Building

The heights of certain Buildings which lie adjacent to each other are given. Light starts falling from left side of the buildings. If there is a building of certain Height, all the buildings to the right side of it having lesser heights cannot see the sun . The task is to find the total number of such buildings that receive light.

### Input Format

- First line contains the Number of Testcases T.
- Next line contains the totalnumber of buildings
- Next line contains the height of n buildings.

### Constraints

```
1 <= T <= 100
1 <= N <= 100
1 <= Hi <= 100
```

### Output Format

Print total Number of buildings that receive Light.

### Sample Input

```
2
8
5 3 9 6 10 11 8 13
6
3 4 1 6 2 3
```

### Sample Output

```
5
3
```

### Explanation

**Algorithm** :

- We can solve the problem by checking if the height of a particular building is greater than the height of all buildings on its left then it will receive sunlight. The steps to solve the problem are:

- Step 1:Initialize a variable t (int t denoting number of test cases) and for t cases initialize variables int n,curmax=INTMIN,res=0.

- Step 2: Using loop from i=0 till i < n take ‘n’ number of buildings and on getting each building compare it with the curmax if curmax<=num then increment res by 1 and update cur_max equal to num.

- Step 3: When i=n print the res.

### Time Complexity

Time complexity of this solution is O(1).
