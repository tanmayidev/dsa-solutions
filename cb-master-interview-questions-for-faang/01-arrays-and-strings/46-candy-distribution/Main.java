import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static int candy(int r[])
  {
    int a[] = new int[r.length];
    a[0] = 1;

    for(int i=1;i<a.length;i++)
    {
      if(r[i] > r[i-1]) 
        a[i] = a[i-1] + 1;
      else 
        a[i] = 1;
    }
    
    for(int i = a.length-2; i >= 0 ;i--)
      if(r[i] > r[i+1])
        if(a[i] < a[i+1] + 1)
          a[i] = a[i+1] + 1;
    
    int s = 0;
    for(int i : a) 
      s += i;
      
    return s;
  }

  public static void main (String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int a[] = new int[n];

    for(int i=0;i<n;i++)
      a[i] = scn.nextInt();

    System.out.println(candy(a));
  }
}