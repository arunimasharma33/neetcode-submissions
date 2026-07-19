class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, result, ds, used);
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, ArrayList<Integer> ds, boolean[] used) {
        if (ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                ds.add(nums[i]);

                backtracking(nums, result, ds, used);

                ds.remove(ds.size() - 1);
                used[i] = false;
            }
        }
    }
}
