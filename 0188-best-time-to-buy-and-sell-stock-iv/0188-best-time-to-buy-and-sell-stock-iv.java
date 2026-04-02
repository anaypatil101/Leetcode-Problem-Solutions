class Solution {
    public int maxProfit(int k, int[] arr) {
       int n = arr.length;
       int[][] dp = new int[2][k+1];
       
       // base cases (here optional coz be default array contains 0 in java)
        for(int buy=0; buy<=1; buy++) {
            dp[buy][0] = 0;
        }
        int[][] next = new int[2][k+1];
        
        for(int ind = n-1; ind>=0; ind--) {
            for(int buy = 0; buy <=1; buy++) {
                for(int cap=1; cap<=k; cap++) {
                    int opt1 = 0, opt2 = 0;
                    if(buy == 0) {
                        // buy
                        opt1 = -arr[ind] + next[1][cap];
                        // skip
                        opt2 = 0 + next[0][cap];                     
                    }
                    else {
                        // sell 
                        opt1 = arr[ind] + next[0][cap-1];
                        // skip
                        opt2 = 0 + dp[1][cap];
                    }
                    dp[buy][cap] = Math.max(opt1, opt2);
                }

                for(int i = 0; i<2; i++)
                    next[i] = dp[i].clone();
            }
        }
        return next[0][k];
    }
}

