class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] req : prereqs) adj.get(req[1]).add(req[0]);
        char[] courseStatus = new char[numCourses];
        Arrays.fill(courseStatus, 'N');

        for(int i = 0; i < numCourses; i++){
            if(courseStatus[i] == 'N'){
                boolean isPossible = courseCheckUtil(i, adj, courseStatus);
                if(!isPossible) return false;
            }
        }

        return true;
    }

    boolean courseCheckUtil(int node, List<List<Integer>> adj, char[] courseStatus){
        if(courseStatus[node] == 'Y') return true;
        if(courseStatus[node] == 'P') return false;

        courseStatus[node] = 'P';
        for(int reqCourse : adj.get(node)){
            boolean courseCheck = courseCheckUtil(reqCourse, adj, courseStatus);
            if(!courseCheck) return false;
        }
        courseStatus[node] = 'Y';
        return true;
    }
}