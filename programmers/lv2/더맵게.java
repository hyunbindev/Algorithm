//https://school.programmers.co.kr/learn/courses/30/lessons/42626
import java.util.*;
class Solution {
    public int solution(int[] sv, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int food : sv){
            pq.add(food);
        }
        while(!pq.isEmpty()){
            int f1 = pq.poll();
            if(f1 < K){
                answer++;
                Integer f2 = pq.poll();
                if(f2 == null) return -1;
                pq.add(f1+(f2*2));
            }else{
                break;
            }
        }
        return answer;
    }
}
