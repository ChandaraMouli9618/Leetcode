class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i = 0; i < n-1; i++) adj.add(new ArrayList());
        for(int i = 0; i < n-1; i++) adj.get(i).add(new Node(i+1, 1));
        //for(List<Node> nodes : adj) System.out.println(nodes.toString());

        int queryCount = queries.length;
        int[] res = new int[queryCount];
        System.out.println(shortPath(0, n-1, n, adj));
        for(int i = 0; i < queryCount; i++){
            int[] query = queries[i];
            adj.get(query[0]).add(new Node(query[1], 1));
            res[i] = shortPath(0, n-1, n, adj);
            //System.out.println();
        }

        return res;
    }

    int shortPath(int src, int dest, int n, List<List<Node>> adj){

        boolean[] isVisited = new boolean[n];

        Queue<Node> queue = new PriorityQueue<>(
            (a,b) -> a.distance - b.distance
        );

        Node node = new Node(src, 0);
        queue.add(node);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            int currDest = currNode.dest;
            int currDistance = currNode.distance;
            //System.out.println(currDistance);

            if(dest == currDest) return currDistance;

            if(isVisited[currDest]) continue;
            isVisited[currDest] = true;

            for(Node nextNode : adj.get(currDest)){
                if(!isVisited[nextNode.dest])
                queue.add(new Node(nextNode.dest, currDistance + nextNode.distance));
            }
        }

        return -1;
    }
}

class Node{
    int dest;
    int distance;

    public Node(int dest, int distance){
        this.dest = dest;
        this.distance = distance;
    }

    public String toString(){
        return "dest : " + dest + " , distance : " + distance;
    }
}