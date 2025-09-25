//https://school.programmers.co.kr/learn/courses/30/lessons/12899
import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        return convert(n);
    }
    String convert(int n){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            if(n%3 == 0){
                sb.append('4');
                n--;
            }else{
                sb.append(n%3);
            }
            n/=3;
        }
        return sb.reverse().toString();
    }
}
