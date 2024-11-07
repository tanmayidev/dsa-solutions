import java.util.*;
public class Main {
public static class Interval {
int start;
int end;
Interval() { start = 0; end = 0; }
Interval(int s, int e) { start = s; end = e; }
}
public static boolean canAttendMeetings(Interval[] intervals)
{
if (intervals == null || intervals.length ==0) {
return true;
}
// Sort according to the start time
Arrays.sort(intervals, new Comparator<Interval>() {
@Override
public int compare(Interval a, Interval b) {
return a.start - b.start;
}
});

Interval prev = intervals[0];
for (int i = 1; i < intervals.length; i++) {
Interval curr = intervals[i];
if (isOverlapped(prev, curr)) {
return false;
}
prev = curr;
}
return true;
}
private static boolean isOverlapped(Interval a, Interval b) {
return a.end > b.start;
}
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
int numMeetings = s.nextInt();
Interval[] intervals = new Interval[numMeetings];
for(int i = 0; i < numMeetings; i++) {
Interval interval = new Interval(s.nextInt(),
s.nextInt());
intervals[i] = interval;
}
System.out.println(canAttendMeetings(intervals));
}
}