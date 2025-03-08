import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[right + 1];
        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }
        int[] ans = new int[]{primes.get(0), primes.get(1)};
        int minDiff = ans[1] - ans[0];
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                ans[0] = primes.get(i - 1);
                ans[1] = primes.get(i);
            }
        }
        return ans;
    }
}