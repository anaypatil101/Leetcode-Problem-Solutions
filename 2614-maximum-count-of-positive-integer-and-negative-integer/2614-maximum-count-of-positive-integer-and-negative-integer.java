class Solution {
    public int maximumCount(int[] nums) {
        HashMap<Integer,Integer> pos = new HashMap<>();
        HashMap<Integer,Integer> neg = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            if(n > 0) {
                pos.put(i,n);
            }
            else if(n < 0) {
                neg.put(i, n);
            }
        }

        return Math.max(pos.size(), neg.size());

    }
}