class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet djSet = new DisjointSet(edges.length+1);
        int[] res = new int[2];

        for(int[] edge : edges){
            if(djSet.find(edge[0]) == djSet.find(edge[1])){
                res[0] = edge[0];
                res[1] = edge[1];
            }
            else{
                djSet.union(edge[0], edge[1]);
            }
        }
        // System.out.println(Arrays.toString(djSet.parent));
        return res;
    }
}

class DisjointSet{
    int[] parent;

    DisjointSet(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        parent[rootB] = rootA;
    }

    int find(int a){
        if(parent[a] != a) parent[a] = find(parent[a]);
        return parent[a];
    }
}