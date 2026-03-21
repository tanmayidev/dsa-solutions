public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    List<List<Integer>> arr = new ArrayList<>();
    
    // Initialize n empty arrays
    for (int i = 0; i < n; i++) {
        arr.add(new ArrayList<>());
    }

    int lastAnswer = 0;
    List<Integer> result = new ArrayList<>();

    for (List<Integer> q : queries) {
        int type = q.get(0);
        int x = q.get(1);
        int y = q.get(2);

        int idx = (x ^ lastAnswer) % n;

        if (type == 1) {
            arr.get(idx).add(y);
        } else {
            List<Integer> seq = arr.get(idx);
            lastAnswer = seq.get(y % seq.size());
            result.add(lastAnswer);
        }
    }

    return result;
}