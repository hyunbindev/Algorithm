//https://school.programmers.co.kr/learn/courses/30/lessons/42842
import java.util.*;
class Solution {
    public Integer[] solution(int brown, int yellow) {
        Integer[] answer = new Integer[2];
        for(int a=1; a<=yellow; a++){
            if(yellow%a==0){
                int b=yellow/a;
                if(2*a+2*b+4 == brown){
                    answer[0]=a+2;
                    answer[1]=b+2;
                    break;
                }
            }
        }
        Arrays.sort(answer,(a,b)->b-a);
        return answer;
    }
}
