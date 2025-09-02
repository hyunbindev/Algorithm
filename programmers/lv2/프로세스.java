//https://school.programmers.co.kr/learn/courses/30/lessons/42587
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<P> q = new LinkedList<>();
        
        for(int i =0; i<priorities.length; i++){
            pq.add(priorities[i]);
            if(i == location){
                q.add(new P(priorities[i],true));
                continue;
            }
            q.add(new P(priorities[i],false));
        }
        
        while(!pq.isEmpty()){
            int first = pq.poll();
            while(!q.isEmpty() && q.peek().priority != first){
                P later = q.poll();
                q.add(later);
            }
            
            answer++;
            if(q.poll().target) break;
        }
        return answer;
    }
    
    class P{
        int priority;
        boolean target;
        P(int p, boolean target){
            this.priority = p;
            this.target =target;
        }
    }
}
