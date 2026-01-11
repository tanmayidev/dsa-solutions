// Recursive Solution (top-down)

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] = max ASCII sum of common subsequence
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int total = asciiSum(s1) + asciiSum(s2);
        int common = dp[m][n];

        return total - 2 * common;
    }

    private int asciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}

// Memoization (top-down dp)

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // Memoization table: -1 means not computed yet
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        int maxCommonAscii = findMaxCommonAscii(s1, s2, 0, 0, memo);
        int total = asciiSum(s1) + asciiSum(s2);
        return total - 2 * maxCommonAscii;
    }
    
    private int findMaxCommonAscii(String s1, String s2, int i, int j, int[][] memo) {
        // Base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        
        // Check if already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        
        int result;
        if (c1 == c2) {
            result = c1 + findMaxCommonAscii(s1, s2, i + 1, j + 1, memo);
        } else {
            int skipS1 = findMaxCommonAscii(s1, s2, i + 1, j, memo);
            int skipS2 = findMaxCommonAscii(s1, s2, i, j + 1, memo);
            result = Math.max(skipS1, skipS2);
        }
        
        // Store in memo table
        memo[i][j] = result;
        return result;
    }
    
    private int asciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}

// DP Solution (bottom-up dp)


class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] = max ASCII sum of common subsequence
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int total = asciiSum(s1) + asciiSum(s2);
        int common = dp[m][n];

        return total - 2 * common;
    }

    private int asciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}
