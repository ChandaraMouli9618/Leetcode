class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>();
        for(long i : nums) queue.add(i);

        int count = 0;
        while(queue.size() >= 2 && queue.peek() < k){
            // System.out.println(count);
            long a = queue.poll();
            long b = queue.poll();
            count++;
            queue.add(Math.min(a,b)*2 + Math.max(a,b));
        }

        return count;
    }
}