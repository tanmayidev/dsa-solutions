class Solution {
    public int longestCycle(int V, int[][] edges) {
        // Build adjacency: next[u] = v (-1 if no outgoing edge)
        int[] next = new int[V];
        Arrays.fill(next, -1);
        for (int[] edge : edges) {
            next[edge[0]] = edge[1];
        }
        
        // visitTime[i] = step at which node i was visited in current DFS
        // -1 means unvisited, 0 means fully processed (part of a prev traversal)
        int[] visitTime = new int[V];
        Arrays.fill(visitTime, -1);
        
        boolean[] processed = new boolean[V];
        int maxCycle = -1;
        
        for (int start = 0; start < V; start++) {
            if (processed[start]) continue;
            
            // Traverse the chain starting from 'start'
            int node = start;
            int step = 1;
            
            while (node != -1 && !processed[node]) {
                // If we've revisited a node from the CURRENT traversal
                if (visitTime[node] != -1) {
                    // Cycle found: length = currentStep - visitTime[node]
                    maxCycle = Math.max(maxCycle, step - visitTime[node]);
                    break;
                }
                
                visitTime[node] = step++;
                node = next[node];
            }
            
            // Mark all nodes in this traversal as processed
            node = start;
            while (node != -1 && !processed[node]) {
                processed[node] = true;
                node = next[node];
            }
        }
        
        return maxCycle;
    }
}