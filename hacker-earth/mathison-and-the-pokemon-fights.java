import java.io.*;
import java.util.*;

class TestClass {

    static final int BLOCK = 500;

    static int N;
    static long[] s, t;

    static long[][] sortedS, prefS;
    static long[][] sortedT, prefT;
    static int numBlocks;

    static void buildBlock(int b) {
        int lo = b * BLOCK;
        int hi = Math.min(lo + BLOCK, N);
        int len = hi - lo;

        sortedS[b] = new long[len];
        sortedT[b] = new long[len];
        for (int i = 0; i < len; i++) {
            sortedS[b][i] = s[lo + i];
            sortedT[b][i] = t[lo + i];
        }
        Arrays.sort(sortedS[b]);
        Arrays.sort(sortedT[b]);

        prefS[b] = new long[len + 1];
        prefT[b] = new long[len + 1];
        for (int i = 0; i < len; i++) {
            prefS[b][i + 1] = prefS[b][i] + sortedS[b][i];
            prefT[b][i + 1] = prefT[b][i] + sortedT[b][i];
        }
    }

    static void updateSortedBlock(long[] sorted, long[] pref, long oldVal, long newVal) {
        int len = sorted.length;

        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (sorted[mid] < oldVal) lo = mid + 1;
            else hi = mid;
        }

        int removeIdx = lo;
        if (newVal >= oldVal) {
            int insertIdx = removeIdx;
            while (insertIdx + 1 < len && sorted[insertIdx + 1] < newVal) {
                sorted[insertIdx] = sorted[insertIdx + 1];
                insertIdx++;
            }
            sorted[insertIdx] = newVal;
        } else {
            int insertIdx = removeIdx;
            while (insertIdx - 1 >= 0 && sorted[insertIdx - 1] > newVal) {
                sorted[insertIdx] = sorted[insertIdx - 1];
                insertIdx--;
            }
            sorted[insertIdx] = newVal;
        }

        pref[0] = 0;
        for (int i = 0; i < len; i++) {
            pref[i + 1] = pref[i] + sorted[i];
        }
    }

    static long blockAbsSum(long[] sorted, long[] pref, long C) {
        int len = sorted.length;
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (sorted[mid] < C) lo = mid + 1;
            else hi = mid;
        }
        int cntLess = lo;
        long sumLess = pref[cntLess];
        long sumAll = pref[len];
        return C * cntLess - sumLess + (sumAll - sumLess) - C * (len - cntLess);
    }

    static long queryAbs(long[] arr, long[][] sorted, long[][] pref, int l, int r, long C) {
        long res = 0;
        int bL = l / BLOCK;
        int bR = r / BLOCK;

        if (bL == bR) {
            for (int i = l; i <= r; i++) res += Math.abs(C - arr[i]);
            return res;
        }

        int endL = (bL + 1) * BLOCK - 1;
        for (int i = l; i <= endL; i++) res += Math.abs(C - arr[i]);

        for (int b = bL + 1; b < bR; b++) {
            res += blockAbsSum(sorted[b], pref[b], C);
        }

        int startR = bR * BLOCK;
        for (int i = startR; i <= r; i++) res += Math.abs(C - arr[i]);

        return res;
    }

    static void update(int pos, long newX, long newY) {
        long oldS = s[pos];
        long oldT = t[pos];
        long newS = newX + newY;
        long newT = newX - newY;
        s[pos] = newS;
        t[pos] = newT;

        int b = pos / BLOCK;
        updateSortedBlock(sortedS[b], prefS[b], oldS, newS);
        updateSortedBlock(sortedT[b], prefT[b], oldT, newT);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        s = new long[N];
        t = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            s[i] = x + y;
            t[i] = x - y;
        }

        numBlocks = (N + BLOCK - 1) / BLOCK;
        sortedS = new long[numBlocks][];
        sortedT = new long[numBlocks][];
        prefS = new long[numBlocks][];
        prefT = new long[numBlocks][];

        for (int b = 0; b < numBlocks; b++) buildBlock(b);

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 0) {
                int p = Integer.parseInt(st.nextToken()) - 1;
                long vp = Long.parseLong(st.nextToken());
                long vs = Long.parseLong(st.nextToken());
                update(p, vp, vs);
            } else {
                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;
                long a = Long.parseLong(st.nextToken());
                long b = Long.parseLong(st.nextToken());
                long C = a + b;
                long D = a - b;
                long ans = (queryAbs(s, sortedS, prefS, i, j, C)
                          + queryAbs(t, sortedT, prefT, i, j, D)) / 2;
                sb.append(ans).append('\n');
            }
        }

        System.out.print(sb);
    }
}