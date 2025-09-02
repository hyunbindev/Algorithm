//https://school.programmers.co.kr/learn/courses/30/lessons/131704
import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =1; i<= order.length; i++){
            q.add(i);
        }
        
        for(int i = 0; i<order.length; i++){
            if(!s.isEmpty() && s.peek() == order[i]){
                s.pop();
                answer++;
                continue;
            }
            else if(!q.isEmpty() && q.peek() == order[i]){
                q.poll();
                answer++;
                continue;
            }
            while(!q.isEmpty()){
                int box = q.poll();
                if(box == order[i]){
                    answer++;
                    break;
                }else{
                    s.add(box);
                    if(q.isEmpty()) return answer;
                }
            }
        }
        return answer;
    }
}
