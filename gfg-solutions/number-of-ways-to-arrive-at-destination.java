import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[V];
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    ways[next] = ways[node];
                    pq.offer(new long[]{next, dist[next]});
                } 
                else if (dist[node] + wt == dist[next]) {
                    ways[next] += ways[node];
                }
            }
        }

        return (int) ways[V - 1];
    }
}