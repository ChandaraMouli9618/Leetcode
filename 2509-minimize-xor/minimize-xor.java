class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsNum2 = Integer.bitCount(num2); // Count of set bits in num2
        int setBitsNum1 = Integer.bitCount(num1); // Count of set bits in num1
        
        int x = 0;
        
        if (setBitsNum1 == setBitsNum2) {
            return num1; // num1 already has the required set bits
        }

        if (setBitsNum1 > setBitsNum2) {
            // Reduce the number of set bits to match num2
            int bitsToSet = setBitsNum2;
            for (int i = 31; i >= 0; i--) {
                if ((num1 & (1 << i)) != 0) { // Check if bit is set in num1
                    x |= (1 << i); // Set this bit in x
                    bitsToSet--;
                    if (bitsToSet == 0) break;
                }
            }
        } else {
            // Increase the number of set bits to match num2
            int bitsToSet = setBitsNum2;
            for (int i = 31; i >= 0; i--) {
                if ((num1 & (1 << i)) != 0) { // Use the set bits of num1 first
                    x |= (1 << i);
                    bitsToSet--;
                }
            }
            // Fill remaining bits from lowest positions
            for (int i = 0; i < 31 && bitsToSet > 0; i++) {
                if ((x & (1 << i)) == 0) { // If bit is not already set
                    x |= (1 << i);
                    bitsToSet--;
                }
            }
        }

        return x;
    }
}

// 0 0 0 1
// 1 1 0 0
// 0 0 0 1

