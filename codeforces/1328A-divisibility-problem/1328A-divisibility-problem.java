import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            long remainder = a % b;
            long moves = (b - remainder) % b;
            
            System.out.println(moves);
        }
        
        sc.close();
    }
}