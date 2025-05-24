class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        int n = words.length;
        
        for(int i=0; i<n; i++) {
            String word = words[i];
            if(word.indexOf(x) != -1) {
                indices.add(i);
            }
        }
        return indices;
    }
}