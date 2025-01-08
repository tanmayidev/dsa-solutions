# Buy and Sell Stocks II

Given an array where the ith element represents the price of a given stock on ith day.

Design an algorithm to fine the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times). You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

### Input Format

```
First line contains single integer n denoting the size of the array.
Next line contains n space separated integers denoting the array.
```

### Constraints

```
1 <= N <= 10^6
0 <= Ai <= 10^4
```

### Output Format

```
Print a single integer denoting the max profit possible
```

### Sample Input

```
6
7 1 5 3 6 4
```

### Sample Output

```
7
```

### Explanation

Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

**Algorithm** :

### Time Complexity
