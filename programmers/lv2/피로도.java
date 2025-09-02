//https://school.programmers.co.kr/learn/courses/30/lessons/87946

import java.util.*;
class Solution {
    int[][] dungeons;
    int answer = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visit = new boolean[dungeons.length];
        
        dfs(0,k);
        
        return this.answer;
    }
    void dfs(int depth, int h){
        for(int i =0; i<this.dungeons.length; i++){
            if(!visit[i] && this.dungeons[i][0]<=h){
                visit[i] = true;
                dfs(depth+1, h-dungeons[i][1]);
                visit[i] = false;
            }
        }
        answer = Math.max(depth,answer);
    }
}
