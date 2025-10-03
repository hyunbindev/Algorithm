//https://school.programmers.co.kr/learn/courses/30/lessons/140107
import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long square= (long)d*d;
        for(long y = 0; y<=d; y+=k){
            //x^2+y^2 = d^2;
            long x = (long)Math.sqrt(square-y*y);
            answer+=x/k;
            answer++;
            //System.out.println(answer);
        }
        return answer;
    }
}
