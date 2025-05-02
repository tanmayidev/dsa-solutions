import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static int firstMissingPositive(int a[])
  {
    for(int i=0;i<a.length;i++)
      if(a[i] <= 0 || a[i] > a.length) 
        a[i] = a.length + 2;
    
    for(int i : a)
      if(i > 0 && i <= a.length) 
        a[i-1] = -Math.abs(a[i-1]);
      else if(i < 0 && i >= -a.length) 
        a[-i-1] = -Math.abs(a[-i-1]);

    for(int i=0;i<a.length;i++)
      if(a[i] > 0) 
        return i + 1;
    
     return a.length + 1;
  }
  public static void main (String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int a[] = new int[n];
    
    for(int i=0;i<n;i++)
      a[i] = scn.nextInt();
    
      System.out.println(firstMissingPositive(a));
  }
}