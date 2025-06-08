class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=1; i<=9; i++) {
            solve(i, result, n);
        }

        return result;
    }

    private void solve(int currNum, List<Integer> result, int n) {

        if(currNum > n) {
            return;
        }
        result.add(currNum);

        for(int append = 0; append <= 9; append++) {
            
            int nextNum = currNum * 10 + append;

            if(nextNum > n)
                return;

            solve(nextNum, result, n);
        }
    }
} 