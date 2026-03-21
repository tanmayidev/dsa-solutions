import java.io.*;
import java.util.*;

class TestClass {
    static final long MOD = 1_000_000_007L;
    static final long INV2 = (MOD + 1) / 2; // 500000004

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");

        long[] a = new long[x];
        for (int i = 0; i < x; i++) {
            a[i] = Long.parseLong(parts[i]);
        }

        // d(N) = prod(a[i]+1) mod MOD
        long dN = 1;
        for (int i = 0; i < x; i++) {
            dN = dN * ((a[i] + 1) % MOD) % MOD;
        }

        // d(N)/2 mod MOD using modular inverse of 2
        long halfDN = dN * INV2 % MOD;

        // d(P) = prod(a[i] * d(N)/2 + 1) mod MOD
        long ans = 1;
        for (int i = 0; i < x; i++) {
            long exp = a[i] % MOD * halfDN % MOD;
            ans = ans * ((exp + 1) % MOD) % MOD;
        }

        System.out.println(ans);
    }
}
