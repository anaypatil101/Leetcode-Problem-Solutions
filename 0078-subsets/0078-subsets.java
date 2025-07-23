class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();   
        int n = nums.length;
        makeSubsets(0, new ArrayList<>(), nums, result, n);

        return result;
    }

     private void makeSubsets(int index, List<Integer> curr, int[] nums, List<List<Integer>> result, int n) {
        if(index >= n) {
            //take sum and add to result
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        makeSubsets(index + 1, curr, nums, result,n);

        curr.remove(curr.size() - 1);
        //not take
        makeSubsets(index + 1, curr, nums, result, n);
    }
}