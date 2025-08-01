class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int num : freq.values()) {
            if(num > 1)
                return true;
        }

        return false;
    }
}