class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> result = new ArrayList<>();

        for (int i = a.size() - 1; i >= 0; i--) {
            result.add(a.get(i));
        }

        return result;
    }

}

// Using Collections

/**

import java.util.*;

class Result {

    public static List<Integer> reverseArray(List<Integer> a) {
        Collections.reverse(a);
        return a;
    }
}

 */