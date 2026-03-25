import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] degree = new int[V];
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            degree[u]++;
            degree[v]++;
        }
        
        // Step 2: Add all leaves
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        
        int remainingNodes = V;
        
        // Step 3: Trim leaves
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                
                for (int neighbor : graph.get(leaf)) {
                    degree[neighbor]--;
                    
                    if (degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }
        
        // Remaining nodes are answer
        result.addAll(q);
        return result;
    }
}