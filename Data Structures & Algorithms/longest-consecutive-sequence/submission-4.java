

class Solution {
    public int longestConsecutive(int[] nums) {
        // int n = nums.length;
        // if (n == 0) return 0;

        // Arrays.sort(nums);  // O(n log n)
        // int longest = 1;
        // int current = 1;

        // for (int i = 1; i < n; i++) {
        //     if (nums[i] == nums[i - 1]) {
        //         // skip duplicates
        //         continue;
        //     }
        //     if (nums[i] == nums[i - 1] + 1) {
        //         // consecutive → extend streak
        //         current++;
        //     } else {
        //         // break in sequence → reset streak
        //         current = 1;
        //     }
        //     longest = Math.max(longest, current);
        // }

        // return longest;


        int n=nums.length;
        if(n==0) return 0;
        int longest=0;
        HashSet<Integer> set= new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        for(int num:nums){
            if(!set.contains(num-1)){
                int current=1;
                int currentNum=num;
                while(set.contains(currentNum+1)){
                    current++;
                    currentNum++;
                }
                longest=Math.max(longest, current);
            }
        }
        return longest;
    }
}
