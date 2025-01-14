class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();

        int[] res = new int[n];
        int currRes = 0;

        for(int i = 0; i < n; i++){
            if(A[i] == B[i]) currRes++;
            else{ 
                if(set.contains(A[i])){
                    set.remove(A[i]);
                    currRes++;
                }
                else{
                    set.add(A[i]);
                }

                if(set.contains(B[i])){
                    set.remove(B[i]);
                    currRes++;
                }
                else{
                    set.add(B[i]);
                }
            }
            res[i] = currRes;
        }

        return res;
    }
}