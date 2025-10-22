//https://school.programmers.co.kr/learn/courses/30/lessons/12982
import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        
        for(int i=0; i<d.length; i++){
            if(d[i]<=budget){
                budget-=d[i];
                answer=i+1;
            }else{
                break;
            }
        }
        
        return answer;
    }
}
