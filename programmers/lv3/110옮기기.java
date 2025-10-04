//https://school.programmers.co.kr/learn/courses/30/lessons/77886
import java.util.*;
class Solution {
    public List<String> solution(String[] s) {
        List<String> answer = new LinkedList<>();
        for(String str : s){
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()){
                stack.add(c);
                int size = stack.size();
                if(size<3) continue;
                if(stack.get(size-1)=='0' && stack.get(size-2)=='1' && stack.get(size-3)=='1'){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    cnt++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : stack){
                sb.append(c);
            }
            if(0<cnt){
                for(int i=sb.length()-1; 0<=i; i--){
                    if(sb.charAt(i) == '0'){
                        while(0<cnt){
                            sb.insert(i+1,"110");
                            cnt--;
                        }
                    }
                }
            }
            if(0<cnt){
                while(0<cnt){
                    sb.insert(0,"110");
                    cnt--;
                }
            }
            answer.add(sb.toString());
            //System.out.println(sb.toString());
        }
        return answer;
    }
}
