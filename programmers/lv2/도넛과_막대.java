//https://school.programmers.co.kr/learn/courses/30/lessons/258711
import java.util.*;
class Solution {
    Map<Integer,int[]> node = new HashMap<>();
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        for(int[] edge : edges){
            int u=edge[0],v=edge[1];
            if(node.get(u)==null)
                node.put(u,new int[]{0,0});
            if(node.get(v)==null)
                node.put(v,new int[]{0,0});
            node.get(u)[0]++;
            node.get(v)[1]++;
        }
        
        node.forEach((key,value)->{
            if(2<=value[0] && value[1]==0)
                answer[0]=key;
            if(value[0]==0)
                answer[2]++;
            if(value[0]==2 && 2<=value[1])
                answer[3]++;
        });
        
        answer[1] = node.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}
