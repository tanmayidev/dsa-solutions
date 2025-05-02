import java.util.*;
public class Main {
public static void main(String args[]) {
Scanner s = new Scanner(System.in);
int n = s.nextInt();
int [] arr = new int [n];
for(int i=0;i<n;i++)
arr[i]=s.nextInt();
int lo = 0;
int mid = 0;
int hi = arr.length - 1;
for (int i = 0; i < arr.length; i++) {
if (arr[mid] == 1) {
mid++;
} else if (arr[mid] == 2) {
int t = arr[hi];
arr[hi] = arr[mid];
arr[mid] = t;
hi--;
} else {
int t = arr[lo];
arr[lo] = arr[mid];
arr[mid] = t;
lo++;
mid++;
}
}
for (int i = 0; i < arr.length; i++) {
System.out.print(arr[i] + " ");
}

}
}