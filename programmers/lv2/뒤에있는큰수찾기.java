//https://school.programmers.co.kr/learn/courses/30/lessons/154539
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i =0; i<answer.length; i++){
            answer[i] = -1;
        }
        
        stack.push(0);
        
        
        for(int i =1; i<numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}
