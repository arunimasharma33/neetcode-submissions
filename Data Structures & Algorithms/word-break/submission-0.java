class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is breakable

        // put dictionary words in a set for O(1) lookup
        Set<String> dict = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check more splits
                }
            }
        }

        return dp[n];
    }
}
