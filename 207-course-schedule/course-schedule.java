class Solution {
    char[] courseStatus;
    List<List<Integer>> adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courseStatus = new char[numCourses];
        Arrays.fill(courseStatus, 'N');
        adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<Integer>());
        for(int[] prerequisite : prerequisites) adj.get(prerequisite[0]).add(prerequisite[1]);

        for(int i = 0; i < numCourses; i++){
            if(courseStatus[i] == 'N'){
                if(!dfs(i)) return false;
            }
        }

        return true;
    }

    boolean dfs(int pos){
        if(courseStatus[pos] == 'C') return true;
        if(courseStatus[pos] == 'P') return false;

        courseStatus[pos] = 'P';

        for(int i : adj.get(pos)){
            if(!dfs(i)) return false;
        }

        courseStatus[pos] = 'C';
        return true;
    }
}