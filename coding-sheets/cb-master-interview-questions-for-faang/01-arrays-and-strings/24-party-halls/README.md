# Party Halls

Given an array of meeting time intervals consisting of start and end times [[S1,E1],[S2,E2],...] (SI < EI), find the minimum number of party halls required.

### Input Format

Take input N
Next N line consists of two space-separated integers SI and EI

### Constraints

None

### Output Format

print minimum required room

### Sample Input

```
5
1 4
2 5
3 6
10 11
11 12
```

### Sample Output

```
3
```

### Explanation

**Algorithm** :

Basically we have to compute the maximum number of active halls for the given start and end times on the basis of overlapping time periods.

1. Maintain two arrays namely start[ ] and end[ ] with start and end times by splitting the in[ ][ ] input array.
2. Sort the two arrays maintained in step1.
3. Initialize two variables i and j i.e start index and end index to 0.
4. Initialize two more variables c(Active party halls at instant) and max(maximum number of active halls needed) to 0.
5. If start[i] or start time < end[i] or end time, i.e we have overlapping time periods hence we have a party active. So increment c i.e active party halls and increment start index i.
6. Else time periods are not overlapping so decrement c and increment end index j.
7. Now compute the maximum between c and max to record the max number of active halls.
8. Return max.

### Time Complexity

O(nlogn) as we are sorting the start and end arrays.
