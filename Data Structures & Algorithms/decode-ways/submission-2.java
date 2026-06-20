class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; // base case: empty string

        // first character check
        dp[1] = (s.charAt(0) != '0') ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // single digit decode
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // two digit decode
            int twoDig = Integer.parseInt(s.substring(i - 2, i));
            if (twoDig >= 10 && twoDig <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
