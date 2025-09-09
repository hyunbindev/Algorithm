//https://school.programmers.co.kr/learn/courses/30/lessons/152995#
import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> {if(a[0]+a[1] == b[0]+b[1]) return a[2]-b[2];//오름차순
                     return (b[0]+b[1])-(a[0]+a[1]);//내림차순;
                    });
        int[][] people = new int[scores.length][3];
        
        for(int i =0; i<scores.length; i++){
            people[i][0] = scores[i][0];
            people[i][1] = scores[i][1];
            people[i][2] = i;
        }
        
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });
        
        int MAX_B = Integer.MIN_VALUE;
        
        for(int i =0; i<people.length; i++){
            if(people[i][1]<MAX_B){
                if(people[i][2] == 0) return -1;
            }else{
                MAX_B = people[i][1];
                pq.add(people[i]);
            }
        }
        while(!pq.isEmpty()){
            answer++;
            if(pq.poll()[2] == 0) return answer;
        }
        return answer;
    }
}
