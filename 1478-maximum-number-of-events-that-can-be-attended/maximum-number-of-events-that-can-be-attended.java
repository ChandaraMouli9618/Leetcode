class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(event -> event[0]));
        int lastDay = Arrays.stream(events).mapToInt(e -> e[1]).max().orElse(0);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, count = 0, n = events.length;

        for (int day = 1; day <= lastDay; day++) {
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }
        }
        return count;
    }
}