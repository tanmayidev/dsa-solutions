import java.util.*;

public class Main {
  public static long[] productExceptSelf(int[] nums) {
    int length = nums.length;
    long[] L = new long[length];
    long[] R = new long[length];
    long[] answer = new long[length];
    L[0] = 1;
    
    for (int i = 1; i < length; i++) {
      L[i] = nums[i - 1] * L[i - 1];
    }
    
    R[length - 1] = 1;
    
    for (int i = length - 2; i >= 0; i--) {
      R[i] = nums[i + 1] * R[i + 1];
    }
    
    for (int i = 0; i < length; i++) {
      answer[i] = L[i] * R[i];
    }
    return answer;
  }
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] array = new int[n];
    for(int i = 0; i < n; i++) {
      array[i] = s.nextInt();
    }

    long[] answer = productExceptSelf(array);
    for(int i = 0; i < n; i++) {
      System.out.print(answer[i]+" ");
    }
  }
}