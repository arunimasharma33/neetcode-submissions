class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int loot[]= new int[n+1];
        loot[0]=0;
        loot[1]=nums[0];
        loot[2]=Math.max(nums[0], nums[1]);
        
        for(int i=3; i<=n; i++){
            loot[i]=Math.max(nums[i-1]+loot[i-2], loot[i-1]);
        }
        return loot[n];
    }
}
