//https://school.programmers.co.kr/learn/courses/30/lessons/154540
import java.util.*;
class Solution {
    List<Integer> answer = new LinkedList<>();
    boolean[][]visit;
    int[][] map;
    int[] dx = {0,1,-1,0};
    int[] dy = {1,0,0,-1};
    public List<Integer> solution(String[] maps) {
        visit = new boolean[maps.length][maps[0].length()];
        map = new int[maps.length][maps[0].length()];
        
        for(int y = 0; y<map.length; y++){
            for(int x = 0; x<map[0].length; x++){
                if(maps[y].charAt(x) == 'X'){
                    map[y][x] = -1;
                }else{
                    map[y][x] = Integer.parseInt(String.valueOf(maps[y].charAt(x)));
                }
                //System.out.print(map[y][x]);
                //System.out.print(" ");
            }
            //System.out.println();
        }
        
        for(int y = 0; y<map.length; y++){
            for(int x = 0; x<map[y].length; x++){
                if(!visit[y][x] && map[y][x] != -1){
                    answer.add(bfs(y,x));
                }
            }
        }
        
        Collections.sort(answer, (a,b)->a-b);
        if(answer.size() == 0) answer.add(-1);
        return answer;
    }
    int bfs(int y, int x){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visit[y][x] = true;
        while(!q.isEmpty()){
            int[] land =q.poll();
            sum+= map[land[0]][land[1]];
            for(int i =0; i<4; i++){
                int ny = land[0]+dy[i];
                int nx = land[1]+dx[i];
                if(0<=ny && 0<=nx && ny<map.length && nx <map[ny].length){
                    if(map[ny][nx] != -1 && !visit[ny][nx]){
                        q.add(new int[]{ny,nx});
                        visit[ny][nx] = true;
                    }
                }
            }
        }
        return sum;
    }
}
