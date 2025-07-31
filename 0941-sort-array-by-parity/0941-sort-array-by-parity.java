class Solution {
    public int[] sortArrayByParity(int[] nums) {

        if(nums.length == 1) return nums;

        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 0)
                evenMap.put(i, nums[i]);
            else 
                oddMap.put(i, nums[i]);
        }

        int count = 0;
        for(int a : evenMap.values()) {
            nums[count] = a;
            count++;
        }
        for(int a : oddMap.values()) {
            nums[count] = a;
            count++;
        }

        return nums;
    }
}