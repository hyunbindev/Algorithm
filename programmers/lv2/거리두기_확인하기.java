//https://school.programmers.co.kr/learn/courses/30/lessons/81302
import java.util.*;
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public List<Integer> solution(String[][] places) {
        List<Integer> answer = new LinkedList<>();
        
        for(String[] place:places){
            boolean pass=true;
            for(int y=0;y<place.length; y++){
                for(int x=0; x<place[y].length(); x++){
                    if(place[y].charAt(x)=='P' && !bfs(place,y,x)){
                        pass=false;
                        continue;
                    }
                }
                if(!pass)continue;
            }
            if(pass){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }
        
        return answer;
    }
    boolean bfs(String[] place, int y, int x){
        boolean[][] visit = new boolean[place.length][place[0].length()];
        Queue<int[]> q = new LinkedList<>();
        visit[y][x]=true;
        for(int i=0; i<4; i++){
            int ny=y+dy[i],nx=x+dx[i];
            if(0<=ny && 0<=nx && ny<place.length&& nx<place[ny].length() && place[ny].charAt(nx) != 'X'){
                q.add(new int[]{ny,nx,1});
                visit[ny][nx]=true;
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int py=p[0],px=p[1];
            if(place[py].charAt(px) == 'P')return false;
            visit[py][px]=true;
            if(1<p[2]) continue;
            for(int i=0; i<4; i++){
                int ny=py+dy[i],nx=px+dx[i];
                if(0<=ny && 0<=nx && ny<place.length&& nx<place[ny].length() && !visit[ny][nx] && place[ny].charAt(nx) != 'X'){
                    q.add(new int[]{ny,nx,p[2]+1});
                    visit[ny][nx]=true;
                }
            }
        }
        return true;
    }
}
