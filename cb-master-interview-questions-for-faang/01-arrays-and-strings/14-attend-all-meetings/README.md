# Attend All Meetings

Mukesh is a wealthy businessman. He has several meetings to attend. Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if mukesh could attend all meetings.

### Input Format

First line contains an integer n, representing number of meetings mukesh has to attend. n lines following contains two values start time and end time each.

### Constraints

None

### Output Format

true if he can attend all meetings else false.

### Sample Input

```
3
0 30
5 10
15 20
```

### Sample Output

```
false
```

### Explanation

(0,30), (5,10) and (0,30),(15,20) will conflict or overlap

**Algorithm** :

Sort the array of Intervals according to the start time of meetings.

Iterate over the intervals array.

Compare end time of previous interval with start time of current interval, and check if both are overlapping i.e if

End Time of Previous Interval > Start time of current interval.

If overlapping is found, return false i.e a person cannot attend all the meetings.

If no overlapping is found over all the intervals, return true.

Illustration:-
[0, 30] , [5, 10]

After sorting according to start time:
[0, 30], [5, 10]

Now the end time of 0th interval i.e 30 is greater than start time of 1st interval i.e 5, so it is practically impossible for the person to attend the second meeting.

### Time Complexity

```
O(nlogn) due to sorting
```
