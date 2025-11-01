//https://school.programmers.co.kr/learn/courses/30/lessons/133502
import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int ing : ingredient){
            stack.add(ing);
            if(stack.size()<4) continue;
            
            //System.out.println(stack);
            int a=stack.get(stack.size()-1), b=stack.get(stack.size()-2), c=stack.get(stack.size()-3), d=stack.get(stack.size()-4);
            if(a==1 && b==3 && c==2 && d==1){
                for(int i=0; i<4; i++) stack.pop();
                answer++;
            }
        }
        return answer;
    }
}
