class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> temp = new ArrayList();
        dfs(result, temp, 0, nums);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> temp, int level, int[] nums) {
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        // do not pick the current number
        dfs(result, temp, level + 1, nums);
        
        // pick current number
        temp.add(nums[level]);
        dfs(result, temp, level + 1, nums);
        temp.remove(temp.size() - 1);
    }
}