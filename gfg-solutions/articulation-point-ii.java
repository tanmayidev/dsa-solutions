import java.util.*;

class Solution {

    static int timer;
    static ArrayList<Integer> result;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        // Build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];

        timer = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, tin, low, isAP, adj);
            }
        }

        result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }

        if (result.size() == 0) {
            result.add(-1);
        }

        Collections.sort(result);
        return result;
    }

    static void dfs(int u, int parent, boolean[] visited, int[] tin, int[] low,
                    boolean[] isAP, ArrayList<ArrayList<Integer>> adj) {

        visited[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {

            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, visited, tin, low, isAP, adj);

                low[u] = Math.min(low[u], low[v]);

                // Articulation condition
                if (low[v] >= tin[u] && parent != -1) {
                    isAP[u] = true;
                }

                children++;
            } else {
                // Back edge
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        // Root case
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}