class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            if(nums[i] != 0) {
                arrList.add(nums[i]);
            }
        }

        int i = 0;
        for(int num : arrList) {
            nums[i] = num;
            i++;
        }
        i = arrList.size();

        while(i < n) {
            nums[i] = 0;
            i++;
        }
    }
}