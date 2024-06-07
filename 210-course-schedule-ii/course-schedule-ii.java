class Solution {
    char[] courseStatus;
    int ptr = 0;
    int[] courseCompletionOrder;
    List<List<Integer>> adj;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courseStatus = new char[numCourses];
        Arrays.fill(courseStatus, 'N');
        adj = new ArrayList<>();
        courseCompletionOrder = new int[numCourses];
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<Integer>());
        for(int[] prerequisite : prerequisites) adj.get(prerequisite[0]).add(prerequisite[1]);

        for(int i = 0; i < numCourses; i++){
            if(courseStatus[i] == 'N'){
                if(!dfs(i)) return new int[0];
            }
        }

        return courseCompletionOrder;
    }

    boolean dfs(int pos){
        if(courseStatus[pos] == 'C') return true;
        if(courseStatus[pos] == 'P') return false;

        courseStatus[pos] = 'P';

        for(int i : adj.get(pos)){
            if(!dfs(i)) return false;
        }

        courseStatus[pos] = 'C';
        courseCompletionOrder[ptr++] = pos;
        return true;
    }
}