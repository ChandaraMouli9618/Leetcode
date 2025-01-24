class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodeCount = graph.length;
        boolean[] isSafeNode = new boolean[nodeCount];
        List<List<Integer>> modGraph = new ArrayList<>();
        for(int i = 0; i < nodeCount; i++) modGraph.add(new ArrayList<>());
        Queue<Integer> nodeQueue = new LinkedList<>();

        for(int i = 0 ; i < nodeCount; i++){
            if(graph[i].length == 0){
                isSafeNode[i] = true;
                nodeQueue.add(i);
                continue;
            }

            for(int nextNode : graph[i]){
                modGraph.get(nextNode).add(i);
            }
        }

        while(!nodeQueue.isEmpty()){
            int currNode = nodeQueue.poll();
            boolean isCurrNodeSafe = true;

            for(Integer nextNode : graph[currNode]){
                if(!isSafeNode[nextNode]){
                    isCurrNodeSafe = false;
                    break;
                }
            }

            if(isCurrNodeSafe){
                isSafeNode[currNode] = true;
                for(Integer nextNode : modGraph.get(currNode)){
                    nodeQueue.add(nextNode);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nodeCount; i++){
            if(isSafeNode[i]) res.add(i);
        }

        return res;
    }
}