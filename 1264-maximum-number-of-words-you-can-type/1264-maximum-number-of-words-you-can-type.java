class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] letters = new boolean[26]; 
        
        for(char ch : brokenLetters.toCharArray()) {
            letters[ch - 'a'] = true;
        }
        int result = 0;
        boolean canType = true;

        for(char ch : text.toCharArray()) {
            if(ch == ' ') {
                if(canType) {
                    result++;
                }
                canType = true;
            }
            else if(letters[ch - 'a']) {
                    canType = false;
                }  
            }
        if(canType)
            result++;

        return result;
    }
}