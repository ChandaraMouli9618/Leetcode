class Solution {
    public int countGoodNumbers(long n) {
        int mod = (int)1_000_000_007;
        long evenPositions = (n + 1) / 2; // 0, 2, 4, ... (even indices)
        long oddPositions = n / 2;         // 1, 3, 5, ... (odd indices)
        
        long result = (power(5, evenPositions, mod) * power(4, oddPositions, mod)) % mod;
        return (int)result;
    }
    
    private long power(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {           // If exponent is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;     // Square the base
            exp >>= 1;                      // Divide exponent by 2
        }
        return result;
    }
}
