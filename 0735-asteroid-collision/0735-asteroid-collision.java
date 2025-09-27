class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=0; i<n; i++) {
            if(arr[i] > 0) {
                st.push(arr[i]);
            }
            else {
                while(!st.empty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) {
                    st.pop();
                }
                
                if(!st.empty() && st.peek() == Math.abs(arr[i])) {
                    st.pop();
                }
                else if(st.empty() || st.peek() < 0) {
                    st.push(arr[i]);
                }
            }
        }
        List<Integer> arrList = new ArrayList<>(st);

        int[] result = new int[arrList.size()];
        int i = 0;
        for(int a : arrList) {
            result[i++] = a;
        }
        return result;
    }
}