class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];
        solve(nums, curr, result, isValid);
        return result;
    }

    private void solve(int[] nums, List<Integer> curr, List<List<Integer>> result, boolean[] isValid) {

        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(isValid[i] == false) {
                curr.add(nums[i]);
                isValid[i] = true;
                solve(nums,curr, result, isValid);
                 isValid[i] = false;
                curr.remove(curr.size() - 1);
            }
        }

        //backtrack
        
    }
     
    
}