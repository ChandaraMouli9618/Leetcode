class Solution {

    boolean[] isVisited;
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        isVisited = new boolean[V];
        Arrays.fill(isVisited, false);
        int provinces = 0;

        for(int i = 0; i < V; i++){
            if(!isVisited[i]){
                dfs(i, adj);
                provinces++;
            }
        }

        return provinces;

    }

    void dfs(int pos, int[][] adj){
        if(isVisited[pos]) return;

        isVisited[pos] = true;
        int[] currList = adj[pos];

        for(int i = 0; i < currList.length; i++){
            if(currList[i] == 1) dfs(i, adj);
        }
    }
}