class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
    
        int total= 0;
        for(int i=0; i<n; i++){
            total+=nums[i];
        }
        if(total%2!=0) return false;
        int target=total/2;
        boolean dp[]= new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            for(int s=target; s>=num; s--){
                if(dp[s-num]){
                    dp[s]=true;
                }
            }
        }
        return dp[target];
    }
}
