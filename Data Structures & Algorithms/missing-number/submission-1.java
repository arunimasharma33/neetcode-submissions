class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        // int sum=0;
        // for(int i=0; i<n; i++){
        //     sum+=nums[i];
        // }
        // int actualSum=(n*(n+1))/2;
        // return actualSum-sum;

        int xor=0;
        int actualXor=0;
        for(int i=0; i<n; i++){
            xor^=nums[i];
        }
        for(int i=0; i<=n;i++){
            actualXor^=i;
        }
        return actualXor^xor;
    }
}
