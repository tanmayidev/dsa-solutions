import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Find leftmost max
        int maxVal = a[0], maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > maxVal) {
                maxVal = a[i];
                maxIndex = i;
            }
        }

        // Find rightmost min
        int minVal = a[0], minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= minVal) {
                minVal = a[i];
                minIndex = i;
            }
        }

        int moves = maxIndex + (n - 1 - minIndex);

        // Adjustment
        if (maxIndex > minIndex) {
            moves--;
        }

        System.out.println(moves);
    }
}