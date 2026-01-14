class Solution {
    fun solution(n: Long): Long {
        var answer:Long = 0L;
        var number:Long = n;
        val numberList = ArrayList<Long>();
        while(number !=0L){
            numberList.add(number%10);
            number/=10;
        }
        numberList.sortDescending();
        for(x in numberList){
            answer = answer*10 + x;
        }
        return answer;
    }
}
