//https://school.programmers.co.kr/learn/courses/30/lessons/389479
import java.util.*;
class Solution {
    Queue<Integer> q = new LinkedList<>();
    //m 서버당 이용자수 , k 운영가능시간
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        for(int i = 0; i<players.length; i++){
            while(!q.isEmpty()){
                if(q.peek() <= i){
                    q.poll();
                    continue;
                }
                break;
            }
            
            int limit = m + q.size()*m;
            if(limit <= players[i]){
                //System.out.println(limit);
                //System.out.println(players[i]);
                //System.out.println();
                for(int j = q.size(); j<players[i]/m; j++){
                    q.add(i+k);
                    answer++;
                }
            }
            //System.out.print(i);
            //System.out.println(q);
        }
        
        return answer;
    }
}
