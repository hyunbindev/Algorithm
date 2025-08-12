//https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        char[] charArr = s.toCharArray();
        
        for(char c : charArr){
            if(stack.empty() || !stack.peek().equals(c)){
                stack.add(c);
            }else{
                stack.pop();
            }
        }
        if(stack.empty()) return 1;
        return 0;
    }
}
