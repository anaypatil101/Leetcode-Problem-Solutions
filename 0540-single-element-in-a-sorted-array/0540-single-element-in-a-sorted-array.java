class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        Map<Integer, Integer> frequency = new HashMap<>();

        for(int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : frequency.entrySet()) {
            if(frequency.get(entry.getKey()) == 1) {
                return entry.getKey();
            }
        }

        return -1;
    } 
}