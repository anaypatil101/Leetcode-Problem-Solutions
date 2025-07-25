class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int negMax = Integer.MIN_VALUE;
        //List<Integer> uniquePos = new ArrayList<>();
        int sum = 0;
        for(int num : nums) {
            if(num <= 0) {
                negMax = Math.max(negMax, num);
            }
            else {
                if(!set.contains(num)) 
                    sum += num;
                
                set.add(num);
            }
        }

        if(sum == 0)
            return negMax;
        else 
            return sum;
    }
}