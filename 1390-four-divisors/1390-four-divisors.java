class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += calculateSum(num);
        }
        return sum;
    }
    public int calculateSum(int num) {
        int sum = 0,divCount = 0;
        for(int fact=1; fact<= Math.sqrt(num); fact++) {
            if(num % fact == 0) {
                int other = num / fact;

                if(other == fact) {
                    divCount++;
                    sum += fact;
                }
                else {
                    divCount += 2;
                    sum = sum + fact + other;
                }
            }
            if(divCount > 4) break; 
        }
        return (divCount == 4) ? sum : 0;
    }
}