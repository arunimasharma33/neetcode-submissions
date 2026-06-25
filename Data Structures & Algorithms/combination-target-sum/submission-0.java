class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        findCom(0, nums, target, ans, ds );
        return ans;
    }
    public void findCom(int i, int[] nums, int target, List<List<Integer>>ans, List<Integer>ds){
        if(i==nums.length){
            if(target==0) ans.add(new ArrayList<>(ds));
            return;
        }
        if(nums[i]<=target){
            ds.add(nums[i]);
            findCom(i, nums, target-nums[i], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCom(i+1, nums, target, ans, ds);
    }
}
