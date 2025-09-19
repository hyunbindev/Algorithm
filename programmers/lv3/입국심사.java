//https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long l = 0;
        long r = (long)times[times.length-1]*n;
        
        while(l<=r){
            long m = (l+r)/2;
            long p=0;
            for(int t :times){
                p+= m/t;
                if(n<p)break;
            }
            if(n<=p){
                answer = m;
                r = m-1;
            }else{
                l=m+1;
            }
        }
        
        return answer;
    }
}
