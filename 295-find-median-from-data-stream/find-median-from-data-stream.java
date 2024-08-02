class MedianFinder{

	Queue<Integer> firstHalf;
	Queue<Integer> secondHalf;
	
	public MedianFinder(){
		firstHalf = new PriorityQueue<>(
Collections.reverseOrder());
		secondHalf = new PriorityQueue<>();
	}

	public void addNum(int num){
		if(firstHalf.size() == 0){
firstHalf.add(num);
return;
}

if(firstHalf.size() != secondHalf.size()){
	int currMedian = firstHalf.poll();
	firstHalf.add(Math.min(currMedian, num));
	secondHalf.add(Math.max(currMedian, num));
}
else{
if(secondHalf.peek() < num){
	firstHalf.add(secondHalf.poll());
	secondHalf.add(num);
}
else{
	firstHalf.add(num);
}
}

}

public double findMedian(){
	if(firstHalf.size() > secondHalf.size()) return firstHalf.peek();
	return (double)(firstHalf.peek() + secondHalf.peek())/2;
}
}


