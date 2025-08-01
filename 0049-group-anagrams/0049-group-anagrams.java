class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] curr = str.toCharArray();
            Arrays.sort(curr);
            String key = new String(curr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> arrList : map.values()) {
            result.add(arrList);
        }

        return result;
    }
}