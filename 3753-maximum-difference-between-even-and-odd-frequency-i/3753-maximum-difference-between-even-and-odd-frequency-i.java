class Solution {
    public int maxDifference(String s) {
        int[] hash = new int[26];

        for(char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }

        int evenCount = Integer.MAX_VALUE;
        int oddCount = 0;

        for(int i=0; i<hash.length; i++) {
            if(hash[i] == 0) continue;
            
            if(hash[i] % 2 == 0) {
                evenCount = Math.min(evenCount, hash[i]);
            }
            else {
                oddCount = Math.max(oddCount, hash[i]);
            }
        }

        return (oddCount - evenCount);
    }
}