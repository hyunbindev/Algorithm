//https://school.programmers.co.kr/learn/courses/30/lessons/12912
class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        
        var big:Long = if(a>b) a.toLong() else b.toLong();
        var small:Long = if(b<a) b.toLong() else a.toLong();
        
        for(x in small..big){
            answer+=x.toLong();
            //println(x);
        }
        return answer
    }
}
