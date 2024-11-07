import java.util.*;
public class Main {
public static boolean isSingle(int a[],int m)
{
if(m == 0 && a[0] != a[1]) return true;
if(m == a.length-1 && a[m] != a[m-1]) return true;
if(a[m] != a[m+1] && a[m]!=a[m-1]) return true;
return false;
}

public static int singleNonDuplicate(int[] a) {
int s=0, e=a.length-1;
if(a.length == 1) return a[0];
while(s <= e)
{
int m = (s+e)/2;
if(isSingle(a,m)) return a[m];
if(m+1<a.length && a[m]==a[m+1])
{
if(m%2 == 0) s = m + 1;
else e = m - 1;
}
else if(m>=1 && a[m] == a[m-1])
{
if(m%2 == 0) e = m - 1;
else s = m + 1;
}
}
return -1;
}
public static void main(String args[]) {
Scanner scn = new Scanner(System.in);
int n = scn.nextInt();
int a[] = new int[n];
for(int i=0;i<n;i++) a[i] = scn.nextInt();
System.out.println(singleNonDuplicate(a));
}
}