class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=dp[0]+cost[0];
        for(int i=2; i<=n; i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        int cost1=dp[n];
        dp[0]=0;
        dp[1]=0;
        dp[2]=dp[1]+cost[1];
        for(int i=3; i<=n; i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        int cost2=dp[n];
        return Math.min(cost1, cost2);
    }
}
