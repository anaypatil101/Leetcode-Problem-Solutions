class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] parent, size;

    // Constructor
    DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
       int n = accounts.size();

       DisjointSet ds = new DisjointSet(n);

       Map<String, Integer> mapMailNode = new HashMap<>();

       for(int i=0; i<n; i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if(!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) 
            mergedMail.add(new ArrayList<>());

        for(var entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findUPar(entry.getValue());

            mergedMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(mergedMail.get(i).isEmpty()) {
                continue;
            }

            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));
            ans.add(temp);
        }
        return ans;
    }
}
     