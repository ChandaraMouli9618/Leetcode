class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
                if(a[1] == b[1]) return b[0] - a[0];
                return a[1] - b[1];
            }
        );
        int overlapCount = 0;
        int prevEndTime = Integer.MIN_VALUE;
        for(int[] interval : intervals){
            if(interval[0] >= prevEndTime){
                prevEndTime = interval[1];
            }
            else{
                overlapCount++;
            }
        }

        return overlapCount;
    }
}