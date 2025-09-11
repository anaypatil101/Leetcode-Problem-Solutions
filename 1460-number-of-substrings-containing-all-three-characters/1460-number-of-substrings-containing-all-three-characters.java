class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), l = 0, r = 0;
        int[] hash = new int[3];
        int count = 0;
        while(r < n) {
            hash[s.charAt(r) - 'a']++;

            while(isSatisfied(hash)) {
                count += (n - r);
                hash[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return count;
    }
    private boolean isSatisfied(int[] hash) {
        if(hash[0] > 0 && hash[1] > 0 && hash[2] > 0) 
            return true;
        
        return false;
    }
}