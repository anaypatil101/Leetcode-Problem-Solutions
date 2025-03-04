class Solution {
    public boolean checkPowersOfThree(int n) {
        int p = 0;

        while(Math.pow(3,p) <= n) {
            p++;
        }
        p = p - 1;   //adjusting the extra increment.

        while(n > 0) {
            if(n >= Math.pow(3,p)) 
                n = (int)(n - Math.pow(3,p));
            
            if(n >= Math.pow(3,p)) 
                return false;

            p--;
        }
        return true;
    } 
}