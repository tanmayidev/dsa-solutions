class Solution {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];
            g[x].add(new int[] { y, w });
            g[y].add(new int[] { x, 2 * w });
        }

        // Dijkstra
        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[] { 0, 0 }); // [Distance, Node]

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dist = current[0];
            int x = current[1];

            if (x == n - 1) {
                return dist;
            }

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            for (int[] neighbor : g[x]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (dist + w < d[y]) {
                    d[y] = dist + w;
                    pq.offer(new int[] { d[y], y });
                }
            }
        }

        return -1;
    }
}

/**********/

/**
=========================================================================================
Algorithm            | Purpose                 | Time Complexity     | Neg Edges | Neg Cycle
=========================================================================================
Dijkstra             | Single-source shortest  | O(E log V)          | ❌        | ❌
Bellman-Ford         | Single-source shortest  | O(V × E)            | ✅        | ✅
Floyd-Warshall       | All-pairs shortest      | O(V³)               | ✅        | ✅
-----------------------------------------------------------------------------------------
0-1 BFS              | Single-source shortest  | O(V + E)            | ❌*       | ❌
SPFA                 | Single-source shortest  | Avg: O(E)           | ✅        | ✅
Johnson’s Algorithm  | All-pairs shortest      | O(VE + V² log V)    | ✅        | ✅
-----------------------------------------------------------------------------------------
BFS                  | Unweighted shortest     | O(V + E)            | ❌        | ❌
DFS                  | Traversal / components  | O(V + E)            | ❌        | ❌
Topological Sort     | DAG ordering            | O(V + E)            | ❌        | ❌
-----------------------------------------------------------------------------------------
DAG Shortest Path    | Shortest path in DAG    | O(V + E)            | ✅        | ❌
A* Search            | Heuristic shortest path | O(E) (heuristic)    | ❌        | ❌
=========================================================================================

Notes:
* 0-1 BFS supports only weights {0,1}
* SPFA is Bellman-Ford optimized with a queue (can TLE in worst case)
* Johnson’s uses Bellman-Ford + Dijkstra
* DAG shortest path requires no cycles

---

graph[u].add(new Edge(v, w));      // Forward: u → v, cost w
graph[v].add(new Edge(u, 2*w));    // Reverse: v → u, cost 2w
```

For every edge `u → v`, the solution adds **both directions** directly:
- Normal traversal: `u → v` costs `w`
- Reversed traversal: `v → u` costs `2w`

### But What About "At Most Once" Constraint?

The constraint says each node's switch can be used **at most once**.

**Key theorem**: Dijkstra with non-negative weights finds **simple paths** (no repeated nodes).

Since we never revisit a node:
- At each node, we make exactly **one** outgoing transition
- That transition is either normal OR reversed
- We never return to use another reversed edge from the same node

**The constraint is automatically satisfied!**

---

## Comparison

| Aspect | My Solution | Simpler Solution |
|--------|-------------|------------------|
| Nodes | `2n` | `n` |
| Edges | `2E + n` | `2E` |
| Graph size | Double | Half |
| Auxiliary logic | Yes | No |

---

## Visual Comparison
```
Original edge: 0 ──5──► 1

My solution (2n nodes):
    0 ──5──► 1
    │
    0 (cost 0)
    ▼
    0' ──10──► ... (complicated)

Simpler solution (n nodes):
    0 ◄──10── 1
      ──5──►
    
    (bidirectional, different costs)
 */

class Solution {
    public int minCost(int n, int[][] edges) {
        // Build bidirectional graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});       // Forward
            graph[v].add(new int[]{u, 2 * w});   // Reverse (2x cost)
        }
        
        // Dijkstra
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});  // {node, distance}
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            
            if (node == n - 1) return d;
            if (d > dist[node]) continue;
            
            for (int[] next : graph[node]) {
                int newDist = d + next[1];
                if (newDist < dist[next[0]]) {
                    dist[next[0]] = newDist;
                    pq.offer(new int[]{next[0], newDist});
                }
            }
        }
        
        return -1;
    }
}

