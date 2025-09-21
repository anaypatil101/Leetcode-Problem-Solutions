class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int grEl;
        for(int a : nums1) {
            grEl = -1;
            for(int i=0; i<nums2.length; i++) {
                if(nums2[i] == a) {
                    grEl = nextGreater(nums2, i);
                    ans.add(grEl);
                    break;
                }
            }
        }

        int[] ansArr = new int[ans.size()];
        int i = 0;
        for(int a : ans) {
            ansArr[i++] = a;
        }
        return ansArr;
    }

    private int nextGreater(int[] arr, int index) {
        int el = arr[index];
        for(int i=index + 1; i<arr.length; i++) {
            if(arr[i] > el) 
                return arr[i];
        }
        return -1;
    }
}