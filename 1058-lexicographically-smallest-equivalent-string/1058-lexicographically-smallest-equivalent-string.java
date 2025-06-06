class Solution {
    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Step 1: Initialize DSU
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Step 2: Union operations
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Step 3: Build the answer
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int rep = find(ch - 'a');
            result.append((char)(rep + 'a'));
        }

        return result.toString();
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union with lexicographically smaller root
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }
}
