import java.io.*;

class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();

            int[] bit = new int[n + 2];
            for (int i = 1; i <= n; i++) bitUpdate(bit, i, 1, n);

            char[] result = new char[n];

            // Process s left to right: s[i] was removed when remaining size = (n - i)
            for (int i = 0; i < n; i++) {
                int size = n - i;               // remaining size at this step
                int rank = (size - 1) / 2 + 1; // 1-based rank of median in remaining slots
                int pos  = bitFindKth(bit, rank, n);
                result[pos - 1] = s.charAt(i);
                bitUpdate(bit, pos, -1, n);
            }

            out.append(new String(result)).append('\n');
        }
        System.out.print(out);
    }

    static void bitUpdate(int[] bit, int i, int delta, int n) {
        for (; i <= n; i += i & (-i)) bit[i] += delta;
    }

    static int bitQuery(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & (-i)) sum += bit[i];
        return sum;
    }

    static int bitFindKth(int[] bit, int k, int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (bitQuery(bit, mid) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}