import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int arr [][] = new int [n][m];
    
    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        arr [i][j] = sc.nextInt();
      }
    }
    
    int ans [] = findDiagonalOrder(arr);
    
    for(int i=0; i<ans.length; i++) {
      System.out.print(ans[i]+" ");
    }
  }
  public static int[] findDiagonalOrder(int[][] arr) {
    // Check for empty matrices
    if (arr == null || arr.length == 0) {
      return new int[0];
    }

    int N = arr.length;
    int M = arr[0].length;
    int[] result = new int[N*M];
    int k = 0;

    ArrayList<Integer> intermediate = new ArrayList<Integer>();
    for (int d = 0; d < N + M - 1; d++) {
      intermediate.clear();

      int r = d < M ? 0 : d - M + 1;
      int c = d < M ? d : M - 1;

      while (r < N && c > -1) {
        intermediate.add(arr[r][c]);
        ++r;
        --c;
      }

      if (d % 2 == 0) {
        Collections.reverse(intermediate);
      }
      for (int i = 0; i < intermediate.size(); i++) {
        result[k++] = intermediate.get(i);
      }
    }
    return result;
  }
}