class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        else if(x > 0) {
            int n = x;
            int digit,rev = 0;
            while(x > 0) {
                digit = x % 10;
                rev = (rev * 10) + digit;
                x = x / 10;
            }

            if(rev == n)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        else  
        {
            return true;
        }

    }
}