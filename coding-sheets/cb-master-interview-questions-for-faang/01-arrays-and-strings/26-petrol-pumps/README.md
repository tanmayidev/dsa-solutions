# Petrol Pumps

There are N petrol pumps along a circular route, where the amount of gas at pump i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from pump i to its next pump (i+1). You begin the journey with an empty tank at one of the petrol pumps.
Return the starting petrol pump's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

### Input Format

Take input N denotes N gas stations along a circular route The first N line contains integers representing the amount of gas at station i is gas[i]. The next N line contains integers representing the amount of cost[i]

### Constraints

Note:

- If there exists a solution, it is guaranteed to be unique.
- Both input arrays are non-empty and have the same length.
- Each element in the input arrays is a non-negative integer.

### Output Format

print the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise print -1.

### Sample Input

```
6
1
4
2
3
6
2
2
3
4
5
6
7
```

### Sample Output

```
-1
```

### Explanation

- There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
- You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
- You begin the journey with an empty tank at one of the gas stations.
- Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

- If there exists a solution, it is guaranteeed to be unique
- Both input arrays are non-empty and have the same length
- Each element in the input arrays is a non-negative integer

**Algorithm** :

1. Make a function CanCompleteCircuit and pass array gas[] and cost [] as parameter `CanCompleteCircuit(int gas[], int cost[])`
2. Initialize the variable inside the function

- total=0, curr=0, s=0
- S will keep track of starting index

3. loop from value `i=0` to till `i < N.length()`

   ```
   total += gas[i] - cost[i]
   curr += gas[i] - cost[i]

   if (curr < 0) { // you can't move ith to (i+1)th station, because cost is greater than gas
     s = i+1;  // update s, can't possible to move current station i to next station
     curr = 0; // set curr at 0, whether movement is possible or not for next time
   }
   if(total < 0) { // no index is possible between 0 and n-1, so that you can go to the next station
     return -1;
   }
   else {
     return s;
   }
   ```

**Example** :

```
gas = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]

Explanation :
Start at station 3 (index 3) and fill up with 4 units of gas.
Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3.
The cost is 5.
Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
```

### Time Complexity

O(N) where N is the Size of the array
