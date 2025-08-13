//https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    private int answer = 0;
    public int solution(String s) {
        
        char[] arr = s.toCharArray();
        for(int i =0; i<arr.length; i++){
            Stack<Character> stack = new Stack<>();
            for(int j =0; j<arr.length; j++){
                char c = arr[(i+j)%arr.length];
                if(stack.empty()){
                    stack.push(c);
                }else{
                    if(match(stack.peek(), c)){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }
            }
            if(stack.empty())answer++;
        }
        
        return answer;
    }
    private boolean match(char a, char b){
        if(a == '(' && b == ')') return true;
        if(a == '[' && b == ']') return true;
        if(a == '{' && b == '}') return true;
        return false;
    }
}
