import java.util.*;

class Solution {

    public int minOperations(String s, int k) {
        int n = s.length();
        int zeroCount = countZeros(s);

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Partition nodes by parity (even / odd)
        List<TreeSet<Integer>> paritySets = initializeParitySets(n);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(zeroCount);
        distance[zeroCount] = 0;

        // Mark starting node as visited
        paritySets.get(zeroCount % 2).remove(zeroCount);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int leftBound = getLeftBound(current, n, k);
            int rightBound = getRightBound(current, n, k);

            TreeSet<Integer> candidates = paritySets.get(leftBound % 2);

            // Process all valid next states in range
            Integer next = candidates.ceiling(leftBound);
            while (next != null && next <= rightBound) {
                distance[next] = distance[current] + 1;
                queue.offer(next);
                candidates.remove(next);
                next = candidates.ceiling(leftBound);
            }
        }

        return distance[0] == Integer.MAX_VALUE ? -1 : distance[0];
    }

    private int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }

    private List<TreeSet<Integer>> initializeParitySets(int n) {
        List<TreeSet<Integer>> sets = new ArrayList<>();
        sets.add(new TreeSet<>()); // even
        sets.add(new TreeSet<>()); // odd

        for (int i = 0; i <= n; i++) {
            sets.get(i % 2).add(i);
        }

        return sets;
    }

    private int getLeftBound(int current, int n, int k) {
        int minOverlap = Math.max(k - n + current, 0);
        int maxOverlap = Math.min(current, k);
        return current + k - 2 * maxOverlap;
    }

    private int getRightBound(int current, int n, int k) {
        int minOverlap = Math.max(k - n + current, 0);
        return current + k - 2 * minOverlap;
    }
}
