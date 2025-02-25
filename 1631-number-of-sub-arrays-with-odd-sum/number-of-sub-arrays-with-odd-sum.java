class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int prefixOddSumCount = 0;
        int prefixEvenSumCount = 0;
        int currSum = 0;
        int res = 0;

        for(int i = 0 ; i < arr.length; i++){
            currSum += arr[i];
            if(currSum%2 == 1){
                prefixOddSumCount++;
                res = (res + (prefixEvenSumCount % MOD)) % MOD;
            }
            else{
                prefixEvenSumCount++;
                res = (res + (prefixOddSumCount % MOD)) % MOD;
            }
        }

        return res % MOD + prefixOddSumCount % MOD;
    }
}