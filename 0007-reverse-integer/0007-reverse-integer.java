class Solution {
    public int reverse(int x) {
        int rev = 0;
        rev = reverse_num(x);
        return rev;          
    }

    int reverse_num(int n)
    {
        int rem,rev = 0;
        while(n != 0)
        {
            rem = n % 10;
            if(rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10)
            {
                return 0;
            }
            rev = (rev * 10) + rem;
            n = n / 10;
        }
        return rev;
    }

}