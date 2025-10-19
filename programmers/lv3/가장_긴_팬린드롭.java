//https://school.programmers.co.kr/learn/courses/30/lessons/12904
import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            int left = 0;
            int right = 0;
            while(0<=i-left && i+right<s.length()){
                if(s.charAt(i-left) != s.charAt(i+right)){
                    break;
                }
                answer = Math.max(answer, left+right+1);
                left++;
                right++;
            }
            left =0;
            right = 1;
            while(0<=i-left && i+right<s.length()){
                if(s.charAt(i-left) != s.charAt(i+right)){
                    break;
                }
                answer = Math.max(answer, left+right+1);
                left++;
                right++;
            }
        }
        
        return answer;
    }
}
