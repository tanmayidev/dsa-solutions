import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int max = 100000;
        int[] freq = new int[max + 1];

        // Read heights and build frequency
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            freq[h]++;
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int count = 0;

            // Count multiples of k
            for (int multiple = k; multiple <= max; multiple += k) {
                count += freq[multiple];
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}