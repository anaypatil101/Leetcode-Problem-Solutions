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
        for(int i=1; i<= Math.sqrt(num); i++) {
            if(num % i == 0) {
                int other = num / i;

                if(other == i) {
                    divCount++;
                    sum += i;
                }
                else {
                    divCount += 2;
                    sum = sum + i + other;
                }
            } 
        }
        return (divCount == 4) ? sum : 0;
    }
}