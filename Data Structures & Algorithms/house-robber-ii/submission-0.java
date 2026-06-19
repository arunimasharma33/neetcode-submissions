class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int[] skipLast= new int[n-1];
        int[] skipFirst= new int[n-1];
        for(int i=0; i<n-1; i++){
            skipLast[i]=nums[i];
            skipFirst[i]=nums[i+1];
        }
        int loot_skipfirst= robStraight(skipFirst);
        int loot_skiplast= robStraight(skipLast);
        return Math.max(loot_skipfirst, loot_skiplast);
    }
    public int robStraight(int[] nums){
        int n=nums.length;
        int loot[]= new int[n];
        loot[0]=nums[0];
        loot[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            loot[i]=Math.max(loot[i-1], loot[i-2]+nums[i]);
        }
        return loot[n-1];
    }
}
