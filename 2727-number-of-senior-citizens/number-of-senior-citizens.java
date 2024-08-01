class Solution {
    public int countSeniors(String[] details) {
        	int count = 0;
	
	for(String citizen : details){
		int age = (citizen.charAt(11)-'0') * 10;
		age +=  (citizen.charAt(12)-'0');

		if(age > 60) count++;
	}
	return count;

    }
}