class Solution {
    public int findMinDifference(List<String> tps) {
        List<Node> timeList = new ArrayList<>();
        for(String tp : tps){
            String[] timeSplit = tp.split(":");
            int hrs = Integer.parseInt(timeSplit[0]);
            int mins = Integer.parseInt(timeSplit[1]);
            timeList.add(new Node(hrs, mins));
        }

        Collections.sort(timeList, (a,b) -> {
            if(a.hrs == b.hrs) return a.mins - b.mins;
            return a.hrs - b.hrs;
        });

        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < timeList.size(); i++){
            Node curr = timeList.get(i);
            Node prev = timeList.get(i-1);

            int currDiff = getDiffMins(prev, curr);
            minDiff = Math.min(minDiff, currDiff);
        }

        int endToMidMidNight = 
        getDiffMins(timeList.get(timeList.size()-1), new Node(24, 0));

        int midNightToStart = 
        getDiffMins(new Node(0, 0), timeList.get(0));


        return Math.min(minDiff, endToMidMidNight + midNightToStart);
    }

    int getDiffMins(Node start, Node end){
        return ((end.hrs - start.hrs) * 60) + (end.mins - start.mins);
    }
}



class Node{
    int hrs;
    int mins;

    Node(int hrs, int mins){
        this.hrs = hrs;
        this.mins = mins;
    }
}