class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>( (a,b) -> ( -(a[0]*a[0] + a[1]*a[1]) + (b[0]*b[0] + b[1]*b[1])) );
        for(int[] point : points){
            pq.add(point);
            if(pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][2];
        for(int i = 0 ; i < k; i++){
            res[i] = pq.poll();
        }

        Arrays.sort(res, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));

        return res;
    }


}