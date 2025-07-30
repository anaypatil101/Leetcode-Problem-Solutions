class Solution {
    public boolean areOccurrencesEqual(String s) {
        if(s.length() == 0 || s.length() == 1) return true;

        int hash[] = new int[26];   //for letter (char) hashing

        for(char ch : s.toCharArray()) {        //populate the hash array with frequencies
            hash[ch - 'a']++;
        }

        int count = 0;

        for(int i=0; i<26; i++) {   // 0 -> hash.length - 1
            if(count == 0 && hash[i] != 0) 
                count = hash[i];
            
            if(count != 0 && hash[i] != 0 && count != hash[i]) 
                return false;
        }

        return true;
    }
}