//https://school.programmers.co.kr/learn/courses/30/lessons/258712
import java.util.*;
class Solution {
    Map<String,Integer> index = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        for(int i=0; i<friends.length; i++){
            index.put(friends[i],i);
        }
        int[][] graph = new int[friends.length][friends.length];
        int[] score = new int[friends.length];
        
        for(String gift : gifts){
            String[] part = gift.split(" ");
            int sender = index.get(part[0]);
            int reciever = index.get(part[1]);
            
            graph[sender][reciever]++;
            graph[reciever][sender]--;
            score[sender]++;
            score[reciever]--;
        }
        
        for(int y=0; y<graph.length; y++){
            int cnt =0;
            for(int x=0; x<graph[y].length; x++){
                if(x==y) continue;
                if(0<graph[y][x]){
                    cnt++;
                    continue;
                }
                if(graph[y][x]==0 && score[x] < score[y])cnt++;
            }
            answer = Math.max(cnt,answer);
        }
        
        return answer;
    }
}
