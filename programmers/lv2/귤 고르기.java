//https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int count = 0;
        
        int[] kind = new int[10000001];
        
        for(int t : tangerine){
            kind[t]++;
        }
        
        Arrays.sort(kind);
        
        for(int i =kind.length-1; i>=0; i--){
            count += kind[i];
            answer++;
            if(count >= k){
                break;
            }
        }
        
        return answer;
    }
}
