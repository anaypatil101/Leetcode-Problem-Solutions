class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        solve(0,nums,new ArrayList<>(), result, 0,0,n,k );
        return result;
    }

    private void solve(int ind, int[] nums, List<Integer> curr, List<List<Integer>> result, int count, int sum, int n, int k) {
        if(sum == n && count == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if(sum > n || count > k) return;

        if(ind >= nums.length) return;


        //take a number
        curr.add(nums[ind]);
        solve(ind+1, nums, curr, result, count + 1, sum + nums[ind], n, k);

        //not take
        curr.remove(curr.size() - 1);
        solve(ind + 1, nums, curr, result, count,sum, n, k);
    }
}