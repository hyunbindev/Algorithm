//https://school.programmers.co.kr/learn/courses/30/lessons/142085

import java.util.*;
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    public int solution(int n, int k, int[] enemy) {
        for(int i=0; i<enemy.length; i++){
            pq.add(enemy[i]);
            while(0<k && n<enemy[i] && !pq.isEmpty()){
                k--;
                n+=pq.poll();
            }
            
            if(n<enemy[i]) return i;
            n-=enemy[i];
        }
        return enemy.length;
    }
}
