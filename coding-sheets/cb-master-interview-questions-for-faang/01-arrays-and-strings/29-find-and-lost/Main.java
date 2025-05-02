import java.util.*;
public class Main {
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int x = sc.nextInt();
  int arr [] = new int [n];

  for(int i=0; i<n; i++){
    arr[i] = sc.nextInt();
  }
  System.out.println(FirstOccurence(arr,x)+" "+
  LastOccurence(arr,x));
}

public static int FirstOccurence(int[] arr,int key) {
  int ans=-1;
  int si=0,ei=arr.length-1;

  while(si<=ei) {
    int mid=(si+ei)/2;
    if(arr[mid]==key) {
      ans=mid;
      ei=mid-1;
    } else if(arr[mid]<key) {
      si=mid+1;
    } else {
      ei=mid-1;
    }
  }
  return ans;
}

public static int LastOccurence(int[] arr,int key) {
  int ans=-1;
  int si=0,ei=arr.length-1;

  while(si<=ei) {
    int mid=(si+ei)/2;
    if(arr[mid]==key) {
      ans=mid;
      si=mid+1;
    } else if(arr[mid]<key) {
      si=mid+1;
    } else {
      ei=mid-1;
    }
  }
  
  return ans;
  }
}