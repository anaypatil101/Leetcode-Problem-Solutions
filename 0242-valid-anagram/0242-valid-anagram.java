class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())  
            return false;
        
        int[] freq = new int[26];
        int i=0;

        while(i < s.length()) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
            i++;
        }

        for(int num : freq) {
            if(num != 0) return false;
        }
        return true;
    }
}