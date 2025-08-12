//https://school.programmers.co.kr/learn/courses/30/lessons/42885
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int extraBoat = 0;
        int answer = 0;
        
        Arrays.sort(people);
        int lp = 0;
        int rp = people.length-1;
        while(lp <= rp){
            if(lp == rp){
                extraBoat++;
                break;
            }
            
            if(people[lp]+people[rp] <= limit){
                answer++;
                lp++;
                rp--;
            }else{
                rp--;
                extraBoat++;
            }
        }
        
        return answer+extraBoat;
    }
}
//전략은 작은사람과 큰사람 최대한 같이 태우는게 그리디 아닐까
