import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int K = Integer.parseInt(first[1]);

        int[] color = new int[N + 1];
        int[] result = new int[N + 1];

        String[] col = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            color[i] = Integer.parseInt(col[i - 1]);
        }

        List<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String[] e = br.readLine().split(" ");
            int u = Integer.parseInt(e[0]);
            int v = Integer.parseInt(e[1]);
            tree[u].add(v);
            tree[v].add(u);
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Stack: node, parent, state (0=enter, 1=exit)
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, -1, 0});

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int node = top[0], parent = top[1], state = top[2];
            int c = color[node];

            if (state == 0) {
                // ENTER node

                if (map.containsKey(c) && map.get(c).size() >= K) {
                    ArrayList<Integer> list = map.get(c);
                    result[node] = list.get(list.size() - K);
                } else {
                    result[node] = -1;
                }

                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(node);

                // Push exit state
                stack.push(new int[]{node, parent, 1});

                // Push children
                for (int child : tree[node]) {
                    if (child != parent) {
                        stack.push(new int[]{child, node, 0});
                    }
                }

            } else {
                // EXIT node (backtrack)
                map.get(c).remove(map.get(c).size() - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}