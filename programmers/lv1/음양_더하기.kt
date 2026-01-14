//https://school.programmers.co.kr/learn/courses/30/lessons/76501
class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        
        for(i in 0 until signs.size){
            if(signs[i]) answer+=absolutes[i];
            else answer-=absolutes[i];
        }
        
        return answer
    }
}
