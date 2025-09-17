//https://school.programmers.co.kr/learn/courses/30/lessons/87390
import java.util.*;
class Solution {
    public List<Long> solution(int n, long left, long right) {
        //int[] answer = new int[(int)right-(int)left+1];
        
        List<Long> answer = new LinkedList<>();
        
        for(long i = left; i<=right; i++){
            long c = i/n+1;
            long r = i%n+1;
            answer.add(Math.max(c,r));
        }
        
        
        return answer;
    }
}
