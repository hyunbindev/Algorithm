//https://school.programmers.co.kr/learn/courses/30/lessons/148653
import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(0<storey){
            int a = storey%10;
            if(a<5) answer+=a;
            if(5<a){
                storey+=10;
                answer+=10-a;
            }
            if(a==5){
                int b = (storey/10)%10;
                if(5<=b){
                    storey+=10;
                    answer+=10-a;
                }else{
                    answer+=a;
                }
            }
            storey/=10;
        }
        return answer;
    }
}
//5라면 6이상일 경우 빼는걸로
//2654
