//https://school.programmers.co.kr/learn/courses/30/lessons/12911

import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int number = 0;
        String binary = Integer.toBinaryString(n);
        
        for(int i =0; i<binary.length(); i++){
            if(binary.charAt(i) == '1')number++;
        }
        int target= ++n;
        
        while(!valid(number,target)){
            target++;
        }
        
        return target;
    }
    boolean valid(int number, int target){
        int a = 0;
        String t = Integer.toBinaryString(target);
        for(int i =0; i<t.length(); i++){
            if(t.charAt(i) == '1')a++;
        }
        if(a == number) return true;
        return false;
    }
}
