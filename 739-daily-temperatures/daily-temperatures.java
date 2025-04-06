class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> tempStack = new Stack<>();
        int n = temps.length;
        int[] res = new int[n];
        int peek = n-1;

        for(int i = n-1; i >= 0; i--){
            //if(!tempStack.isEmpty()) System.out.println(tempStack.peek());
            while(!tempStack.isEmpty() && temps[i] >= temps[tempStack.peek()]) tempStack.pop();
            
            if(tempStack.isEmpty()) res[i] = 0;
            else res[i] = tempStack.peek() - i;

            tempStack.push(i);
        }

        return res;
    }
}