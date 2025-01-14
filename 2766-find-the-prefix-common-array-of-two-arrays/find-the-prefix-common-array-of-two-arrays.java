class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        int[] res = new int[n];
        int currRes = 0;

        for(int i = 0; i < n; i++){
            a.add(A[i]);
            b.add(B[i]);

            if(A[i] == B[i]) currRes++;
            else{
                if(b.contains(A[i]))currRes++;
                if(a.contains(B[i]))currRes++;
            }
            res[i] = currRes;
        }

        return res;
    }
}