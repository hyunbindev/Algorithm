//https://school.programmers.co.kr/learn/courses/30/lessons/86051
class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        numbers.sort()
        
        val idx:BooleanArray = BooleanArray(10){true};
        
        for(x in numbers){
            idx[x]=false;
        }
        
        for(i in 0..9){
            if(idx[i])answer+=i;
        }
        
        //println(numbers.contentToString());
        return answer
    }
}
