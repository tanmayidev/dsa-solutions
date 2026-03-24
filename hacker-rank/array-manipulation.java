public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Size n+2 to safely handle b+1 up to n+1 without bounds check
    long[] diff = new long[n + 2];
    
    for (List<Integer> query : queries) {
        int a = query.get(0);
        int b = query.get(1);
        long k = query.get(2);
        
        diff[a] += k;       // range opens at a
        diff[b + 1] -= k;   // range closes after b
    }
    
    // Reconstruct via prefix sum, track max
    long max = 0;
    long runningSum = 0;
    for (int i = 1; i <= n; i++) {
        runningSum += diff[i];
        if (runningSum > max) max = runningSum;
    }
    
    return max;
}