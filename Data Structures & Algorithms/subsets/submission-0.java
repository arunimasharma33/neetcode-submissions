class Solution {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> current=new ArrayList<>();
        backtracking(nums, result, current , 0);
        return result;
    }
    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> current, int start ){
        result.add(new ArrayList<>(current));
        for(int i=start; i<nums.length; i++){
            current.add(nums[i]);
            backtracking(nums, result, current, i+1);
            current.remove(current.size()-1);
        }
    }
}
