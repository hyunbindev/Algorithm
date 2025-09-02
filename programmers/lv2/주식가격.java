//https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=java
import java.util.*;
class Solution {
    private Stack<Integer> stack = new Stack<>();
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        stack.push(0);
        for(int i =1; i<prices.length; i++){
            while(!stack.empty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.empty()){
            answer[stack.peek()] = prices.length - stack.pop() -1;
        }
        return answer;
    }
}
