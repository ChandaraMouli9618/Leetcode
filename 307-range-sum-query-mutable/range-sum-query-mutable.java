class NumArray {

    int[] segTree;
    int[] nums;

    public NumArray(int[] nums) {
        int n = nums.length;
        segTree = new int[4 * n];
        this.nums = nums;
        buildSegTree(nums, 0, 0, n-1);
    }

    private int buildSegTree(int[] nums, int node, int start, int end){
        if(start == end){
            segTree[node] = nums[start];
            return nums[start];
        }

        int mid = start + (end - start)/2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int leftSum = buildSegTree(nums, leftChild, start, mid);
        int rightSum = buildSegTree(nums, rightChild, mid+1, end);

        return segTree[node] = leftSum + rightSum;
    }
    
    public void update(int index, int val) {
        updateNodes(index, 0, val, 0, nums.length-1);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
       return getRangeSum(0, 0, nums.length - 1, left, right);
    }

    private void updateNodes(int index, int pos, int val, int start, int end){
        if(start == end){
            segTree[pos] = val;
            return;
        }
        int mid = start + (end - start)/2;
        int leftChild = 2 * pos + 1;
        int rightChild = 2 * pos + 2;

        if(index <= mid) updateNodes(index, leftChild, val, start, mid);
        else updateNodes(index, rightChild, val, mid+1, end);

        segTree[pos] = segTree[leftChild] + segTree[rightChild];
    }

    private int getRangeSum(int pos, int start, int end, int left, int right){
        
        if(start >= left && end <= right) return segTree[pos];
        if(start > right || end < left) return 0;

        int mid = start + (end - start)/2;
        int leftChild = 2 * pos + 1;
        int rightChild = 2 * pos + 2;

        int leftSum = getRangeSum(leftChild, start, mid, left, right);
        int rightSum = getRangeSum(rightChild, mid+1, end, left, right);

        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */