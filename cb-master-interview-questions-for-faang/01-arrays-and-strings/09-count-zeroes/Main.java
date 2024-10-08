import java.util.*;
public class Main {
  public static int trailingZeroes(int n) {
    if( n < 5 ) 
      return 0;
    
    int res = 0;
    
    while( n > 0 ) {
      n /=5 ;
      res += n;
    }

    return res;
  }
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    System.out.println(trailingZeroes(n));
  }
  
}