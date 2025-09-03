//https://school.programmers.co.kr/learn/courses/30/lessons/42627#

import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> jobq = new PriorityQueue<>(
            Comparator.<int[]>comparingInt((int[] e) -> e[0]).thenComparingInt((int[] e)-> e[1])
        );
        
        PriorityQueue<int[]> readyq = new PriorityQueue<>(Comparator.comparing(e -> e[1]));
        
        for(int[] job : jobs){
            jobq.add(job);
        }
        
        int[] fj = jobq.poll();
        int t = fj[0];
        readyq.add(fj);
        
        int answer = 0;
        
        while(!readyq.isEmpty()){
            int[] endJob = readyq.poll();
            
            t += endJob[1];
            
            answer+= (t-endJob[0]);
            
            while(!jobq.isEmpty()){
                if(jobq.peek()[0] <= t){
                    readyq.add(jobq.poll());
                }else{
                    break;
                }
            }
            
            if(readyq.isEmpty() && !jobq.isEmpty()){
                int[] j = jobq.poll();
                t = j[0];
                readyq.add(j);
            }
            
        }
        
        return answer/jobs.length;
    }
}
