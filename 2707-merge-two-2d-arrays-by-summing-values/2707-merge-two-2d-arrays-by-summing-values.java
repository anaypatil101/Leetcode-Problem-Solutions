class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<m; i++) {
            map.put(nums1[i][0], nums1[i][1]);
        }

        for(int j=0; j<n; j++) {
            if( map.containsKey(nums2[j][0]) ) {
                map.put( nums2[j][0], map.get(nums2[j][0]) + nums2[j][1] );
            }
            else {
                map.put(nums2[j][0], nums2[j][1]);
            }
        }

        TreeMap<Integer,Integer> tmap = new TreeMap<>(map);
        int[][] result = new int[tmap.size()][2];
        int i = 0;
        for(HashMap.Entry<Integer,Integer> ent : tmap.entrySet()) {
            result[i] = new int[]{ent.getKey(), ent.getValue()};
            i++;
        }

        return result;
    }   
}