class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        int reversed = 0;
        boolean isNegitive = false;
        if( x < 0){
            isNegitive = true;
            x *= -1;
        }

        while(x > 0){
            if( reversed > (Integer.MAX_VALUE - (x % 10)) / 10 ) return 0;
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        if(isNegitive) return reversed * -1;
        return reversed;
    }
}