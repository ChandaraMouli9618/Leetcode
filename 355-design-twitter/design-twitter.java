class Twitter {

    Map<Integer, Set<Integer>> followeeMap;
    List<Tweet> tweets;
    Integer time;
    public Twitter() {
        followeeMap = new HashMap<>();
        tweets = new ArrayList<>();
        time = 0;
    }

    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();

        Set<Integer> followeeSet = followeeMap.getOrDefault(userId, null);

        int feedCount = 0;
        for(int i = tweets.size()-1; i >= 0 && feedCount < 10; i--){
            int userPostedTweet = tweets.get(i).userId;
            int tweetId = tweets.get(i).tweetId;
            if(userPostedTweet == userId || (followeeSet != null && followeeSet.contains(userPostedTweet))){
                newsFeed.add(tweetId);
                feedCount++;
            }
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId)){
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followeeMap.containsKey(followerId)){
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}

class Tweet{
    int userId;
    int tweetId;
    int time;
    
    public Tweet(int userId, int tweetId, int time){
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
}