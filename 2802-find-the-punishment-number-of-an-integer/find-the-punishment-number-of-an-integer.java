class Solution {
    public int punishmentNumber(int n) {
        int punishNum = 0;
        for(int i = 1; i <= n; i++){
            if(getPunishNum(i*i+"", i, 0)){
                // System.out.println(i);
                punishNum += i*i;
            }
        }
        return punishNum;
    }

    boolean getPunishNum(String num, int n, int currSum){
        if(num.length() == 0) return n == currSum ? true : false;

        for(int i = 0 ; i < num.length(); i++){
            int currNum = Integer.parseInt(num.substring(0, i+1));
            boolean currRes = getPunishNum(num.substring(i+1, num.length()), n, currNum + currSum);
            if(currRes) return true;
        }

        return false;
    }
}