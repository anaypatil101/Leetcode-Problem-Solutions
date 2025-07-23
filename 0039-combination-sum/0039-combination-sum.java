class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
         
        solve(0, candidates, curr, ans, target, n);
        return ans;
    }
    
    private void solve(int index, int[] arr, List<Integer> curr, List<List<Integer>> ans, int sum, int n) {
        if(sum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(sum < 0 || index == n) {
            return;
        }

        //take
        curr.add(arr[index]);
        solve(index, arr, curr, ans, sum - arr[index], n);

        //not take
        curr.remove( curr.size() - 1 );
        solve(index + 1, arr, curr, ans, sum , n);

    }
}