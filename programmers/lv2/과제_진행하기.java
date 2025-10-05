//https://school.programmers.co.kr/learn/courses/30/lessons/176962
import java.util.*;
class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new LinkedList<>();
        Arrays.sort(plans,(a,b)->getTime(a[1])-getTime(b[1]));
        Stack<Subject> stack = new Stack<>();
        
        for(int i=0; i<plans.length-1; i++){
            String[] plan = plans[i];
            String[] next = plans[i+1];
            int gap = getTime(next[1])-getTime(plan[1]);
            int time = Integer.parseInt(plan[2]);
            if(gap<time){
                stack.add(new Subject(plan[0],time-gap));
            }else{
                answer.add(plan[0]);
                gap -= time;
                while(!stack.isEmpty() && 0<gap){
                    Subject sub = stack.pop();
                    if(sub.time<=gap){
                        gap-=sub.time;
                        answer.add(sub.name);
                    }else{
                        sub.time-=gap;
                        gap=0;
                        stack.add(sub);
                    }
                }
            }
        }
        answer.add(plans[plans.length-1][0]);
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }
        return answer;
    }
    
    int getTime(String time){
        String[] part = time.split(":");
        return Integer.parseInt(part[0])*60 + Integer.parseInt(part[1]);
    }
    
    class Subject{
        String name;
        int time;
        Subject(String name, int time){
            this.name = name;
            this.time = time;
        }
    }
}
