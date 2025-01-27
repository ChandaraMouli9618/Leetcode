class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Initialize a matrix to represent prerequisites (transitive closure)
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Fill the matrix with direct prerequisites
        for (int[] prerequisite : prerequisites) {
            int courseA = prerequisite[0];
            int courseB = prerequisite[1];
            isPrerequisite[courseA][courseB] = true;
        }

        // Apply Floyd-Warshall to find transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Prepare the answer for each query
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            int courseU = query[0];
            int courseV = query[1];
            answer.add(isPrerequisite[courseU][courseV]);
        }

        return answer;
    }
}
