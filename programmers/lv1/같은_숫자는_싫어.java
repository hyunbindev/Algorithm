import java.util.*;

public class Solution {
    public List<Integer> solution(int[]arr) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        answer.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(stack.get(stack.size()-1) == arr[i]) continue;
            stack.push(arr[i]);
            answer.add(arr[i]);
        }

        return answer;
    }
}
