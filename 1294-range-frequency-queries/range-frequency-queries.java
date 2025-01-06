class RangeFreqQuery {

    private Node root;
    private int n;

    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        root = buildSegTree(arr, 0, n-1);
    }
    
    public int query(int left, int right, int value) {
        return queryUtil(root, left, right, value);
    }

    private int queryUtil(Node root, int left, int right, int value){
        if(root == null) return 0;
        int start = root.lowerBound;
        int end = root.upperBound;

        if(start >= left && end <= right) return root.freq.getOrDefault(value, 0);
        if(start > right || end < left) return 0;
        int freq = 0;
        if(root.left != null && root.left.freq.containsKey(value)){
            freq += queryUtil(root.left, left, right, value);
        }
        if(root.right != null && root.right.freq.containsKey(value)){
            freq += queryUtil(root.right, left, right, value);
        }

        return freq;
    }

    private Node buildSegTree(int[] arr, int start, int end){
        if(start == end){
            Node leafNode = new Node(start, end);
            leafNode.freq.put(arr[start], 1);
            return leafNode;
        }

        int mid = start + (end - start)/2;
        Node leftNode = buildSegTree(arr, start, mid);
        Node rightNode = buildSegTree(arr, mid + 1, end);

        Node currNode = new Node(start, end);
        for(Integer key : leftNode.freq.keySet()){
            currNode.freq.put(key, leftNode.freq.get(key));
        }
        for(Integer key : rightNode.freq.keySet()){
            currNode.freq.put(key, currNode.freq.getOrDefault(key, 0) + rightNode.freq.get(key));
        }

        currNode.left = leftNode;
        currNode.right = rightNode;

        return currNode;
    }
}


class Node{
    int lowerBound;
    int upperBound;
    Node left;
    Node right;
    Map<Integer, Integer> freq;

    public Node(int lb, int ub){
        lowerBound = lb;
        upperBound = ub;
        left = right = null;
        freq = new HashMap<>();
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */