import java.util.*;

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {

        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 2: Queue for nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: BFS
        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: Check if all courses processed
        return count == n;
    }
}