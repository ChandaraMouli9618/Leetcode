class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];

        Queue<Integer[]> q = new LinkedList<>();



        for (int k = 0; k < group.length; k++) {
            if (group[k] == 0) {
                q.add(new Integer[] { k , 1 });
                while (!q.isEmpty()) {
                    int size = q.size();
                    // System.out.println(Arrays.toString(group));

                    for (int i = 0; i < size; i++) {
                        Integer[] currNode = q.poll();

                        if (group[currNode[0]] != 0) {
                            if (group[currNode[0]] != currNode[1])
                                return false;
                            else
                                continue;
                        }

                        group[currNode[0]] = currNode[1];
                        for (int j = 0; j < graph[currNode[0]].length; j++) {
                            q.add(new Integer[] { graph[currNode[0]][j], currNode[1] * -1 });
                        }

                    }
                }
            }
        }

        return true;

    }
}