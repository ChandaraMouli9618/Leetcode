class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMin = leftSmaller(heights);
        //System.out.println(Arrays.toString(leftMin));
        int[] rightMin = rightSmaller(heights);
        //System.out.println(Arrays.toString(rightMin));
        
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, ((rightMin[i]-1) - (leftMin[i]+1) + 1) * heights[i]);
        }
        
        return res;
    }

    int[] leftSmaller(int[] heights){
        int n = heights.length;
        int[] immediateSmallerLeft = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        for(int i = 0; i < n; i++){
            while(stack.peek() >= 0 && heights[stack.peek()] >= heights[i]) stack.pop();
            immediateSmallerLeft[i] = stack.peek();
            stack.add(i);
        }

        return immediateSmallerLeft;
    }

    int[] rightSmaller(int[] heights){
        int n = heights.length;
        int[] immediateSmallerRight = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.add(n);

        for(int i = n-1; i >= 0; i--){
            while(stack.peek() < n && heights[stack.peek()] >= heights[i]) stack.pop();
            immediateSmallerRight[i] = stack.peek();
            stack.add(i);
        }

        return immediateSmallerRight;
    }
}