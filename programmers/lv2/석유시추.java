//https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int set[][];
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int idx = 1;
    int[][]land;
    public int solution(int[][] land) {
        if(land.length == 1 && land[0].length == 1){
            return land[0][0] == 1 ? 1:0;
        }
        
        this.set = new int[land.length][land[0].length];
        this.land = land;
        int answer = 0;
        
        for(int y =0; y<land.length; y++){
            for(int x=0; x<land[0].length; x++){
                if(land[y][x] == 1 && set[y][x] == 0){
                    map.put(idx,dfs(y,x));
                    idx++;
                }
            }
        }
        for(int x =0; x<land[0].length; x++){
            Set<Integer> s = new HashSet<>();
            for(int y=0; y<land.length; y++){
                if(set[y][x] != 0)s.add(set[y][x]);
            }
            int sum = 0;
            for(int e : s){
                sum += map.get(e);
            }
            answer = Math.max(answer,sum);
        }
        
        //System.out.println(map);
        
        return answer;
    }
    int dfs(int y, int x){
        set[y][x] = idx;
        int sum = 1;
        for(int i =0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(0<=ny && 0<=nx && ny<land.length && nx<land[0].length){
                if(set[ny][nx] == 0 && land[ny][nx]==1){
                    sum+=dfs(ny,nx);
                }
            }
        }
        return sum;
    }
}
