import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] home = new int[n];
        int[] away = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = sc.nextInt();
            away[i] = sc.nextInt();
        }

        int count = 0;

        // Check all pairs
        for (int i = 0; i < n; i++) {          // host
            for (int j = 0; j < n; j++) {      // guest
                if (i != j && home[i] == away[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}