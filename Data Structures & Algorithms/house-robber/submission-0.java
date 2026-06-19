class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int loot[]= new int[n];
        loot[0]=nums[0];
        loot[1]=Math.max(nums[0], nums[1]);
        
        for(int i=2; i<n; i++){
            loot[i]=Math.max(nums[i]+loot[i-2], loot[i-1]);
        }
        return loot[n-1];
    }
}
