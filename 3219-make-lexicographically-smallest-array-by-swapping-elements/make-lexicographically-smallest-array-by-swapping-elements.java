class Solution {
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Pair elements with their indices
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // Value
            pairs[i][1] = i;       // Original index
        }

        // Sort pairs by values
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        // Initialize Union-Find
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each element starts as its own parent
            rank[i] = 0;
        }

        // Connect indices where the condition holds
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(pairs[i][0] - pairs[i + 1][0]) <= limit) {
                union(parent, rank, pairs[i][1], pairs[i + 1][1]);
            }
        }

        // Group indices by their root
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }

        // Sort elements within each group
        int[] result = nums.clone();
        for (List<Integer> indices : groups.values()) {
            // Extract values from the group
            List<Integer> values = new ArrayList<>();
            for (int index : indices) {
                values.add(nums[index]);
            }

            // Sort the values
            Collections.sort(values);

            // Place sorted values back in the result
            Collections.sort(indices); // Sort indices to place values correctly
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = values.get(i);
            }
        }

        return result;
    }
}