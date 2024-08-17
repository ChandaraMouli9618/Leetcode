class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < V-1; i++){
            for(int j = i+1; j < V; j++){
                int distance = getDistance(points[i], points[j]);
                Edge edge = new Edge(distance, i, j);
                edges.add(edge);
            }
        }
        //System.out.println(edges.size());

        Collections.sort(edges, (a,b) -> a.distance - b.distance);
        UnionFind uf = new UnionFind(V);

        int totalDistance = 0;
        int edgeCount = 0;
        
        for(int i = 0; i < edges.size() && edgeCount < V-1; i++){
            Edge edge = edges.get(i);
            int distance = edge.distance;
            int start = edge.start;
            int end = edge.end;
            if(uf.union(start, end)){
                totalDistance += distance;
                edgeCount++;
            }
        }

        return totalDistance;
    }

    int getDistance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

class UnionFind{
    int[] parent;

    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;
        parent[rootA] = rootB;
        return true;
    }

    int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}

class Edge{
    int distance;
    int start;
    int end;

    public Edge(int distance, int start, int end){
        this.distance = distance;
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}