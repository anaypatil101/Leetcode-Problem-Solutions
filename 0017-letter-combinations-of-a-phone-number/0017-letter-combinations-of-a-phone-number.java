class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;

        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(0, ans, "", digits,map);
        return ans;
    }

    private void helper(int index, List<String> ans, String combn, String digits,String[] map) {
        
        if(index == digits.length()) {
            ans.add(combn);
            return;
        } 

        String curr = map[digits.charAt(index) - '0'];

        for(int i=0; i<curr.length(); i++) {
            helper(index + 1, ans, combn + curr.charAt(i), digits, map);
        }

    }
}