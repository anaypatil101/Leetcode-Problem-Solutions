class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String input : operations) {
            if(input.equals("X++") || input.equals("++X"))
                x++;
            else 
                x--;
        }
        return x;
    }
}