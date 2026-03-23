public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Count frequency of each string in stringList
    Map<String, Integer> freqMap = new HashMap<>();
    for (String s : stringList) {
        freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
    }
    
    // For each query, look up its count (0 if not found)
    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
        result.add(freqMap.getOrDefault(query, 0));
    }
    
    return result;
}