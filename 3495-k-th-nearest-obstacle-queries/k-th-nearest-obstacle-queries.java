class Solution {
    public int[] resultsArray(int[][] qs, int k) {
        Queue<Integer> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(b, a)
        );
        int[] res = new int[qs.length];

        int i = 0;
        for(int[] q : qs){
            queue.add( Math.abs(q[0]) + Math.abs(q[1]) );
            if(queue.size() > k) queue.poll();
            if(queue.size() < k) res[i++] = -1;
            else res[i++] = queue.peek();
        }

        return res;
    }
}