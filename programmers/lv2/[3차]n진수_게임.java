//https://school.programmers.co.kr/learn/courses/30/lessons/17687

import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<=t*m; i++){
            sb.append(convert(i,n));
            //System.out.println(convert(i,n));
        }
        //System.out.println(sb.toString());
        
        String str = sb.toString();
        
        for(int i = 0; i<t; i++){
            answer.append(str.charAt(i*m+p-1));
        }
        
        return answer.toString();
    }
    //진법을 만들자
    String convert(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num/n != 0){
            sb.append(remainToString(num%n));
            num /= n;
        }
        sb.append(remainToString(num%n));
        
        return sb.reverse().toString();
    }
    String remainToString(int num){
        if(num<10) return Integer.toString(num);
        return "" + (char)(num+55);
    }
}
