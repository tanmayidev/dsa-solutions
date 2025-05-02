import java.util.*;
public class Main {
  public static int minMeetingRooms(int[][] in) {
    int[] start = new int[in.length], end = new int[in.length];
    
    for(int i=0;i<in.length;i++)
    {
      start[i] = in[i][0];
      end[i] = in[i][1];
    }
    
    Arrays.sort(start);
    Arrays.sort(end);
    
    int i = 0, j = 0;
    int c = 0, max = 0;
    while(i < in.length && j < in.length)
    {
      if(start[i] < end[j]) {
        i++; 
        c++;
      }
      else {
        j++; 
        c--;
      }
      if(max < c) 
        max = c;
    }
  return max;
}

  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int a[][] = new int[n][2];
    for(int i=0;i<n;i++)
    {
      a[i][0] = scn.nextInt();
      a[i][1] = scn.nextInt();
    }
    System.out.println(minMeetingRooms(a));
  }
}