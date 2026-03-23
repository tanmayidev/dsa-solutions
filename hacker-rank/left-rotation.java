public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    int n = arr.size();
    d = d % n;

    List<Integer> result = new ArrayList<>();

    // Add elements from d to end
    for (int i = d; i < n; i++) {
        result.add(arr.get(i));
    }

    // Add elements from 0 to d-1
    for (int i = 0; i < d; i++) {
        result.add(arr.get(i));
    }

    return result;
}