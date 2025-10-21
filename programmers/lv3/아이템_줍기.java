//https://school.programmers.co.kr/learn/courses/30/lessons/87694
import java.util.*;
class Solution {
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] map = new boolean[150][150];
        int[][] visit = new int [150][150];
        
        for(int y=0; y<visit.length; y++)
            for(int x=0; x<visit[y].length; x++)
                visit[y][x]=Integer.MAX_VALUE;
        
        for(int[] rect: rectangle){
            int x1=rect[0]*2, y1=rect[1]*2,x2=rect[2]*2, y2=rect[3]*2;
            for(int y=y1; y<=y2; y++)
                for(int x=x1; x<=x2; x++)
                    map[y][x]=true;
        }
        for(int[] rect: rectangle){
            int x1=rect[0]*2, y1=rect[1]*2,x2=rect[2]*2, y2=rect[3]*2;
            for(int y=y1+1; y<y2; y++)
                for(int x=x1+1; x<x2; x++)
                    map[y][x]=false;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY*2,characterX*2});
        visit[characterY*2][characterX*2]=0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int py=p[0],px=p[1];
            for(int i=0; i<4; i++){
                int ny =py+dy[i], nx=px+dx[i];
                if(visit[py][px]+1<visit[ny][nx] && map[ny][nx]){
                    visit[ny][nx]=visit[py][px]+1;
                    q.add(new int[]{ny,nx});
                }
            }
        }
        return visit[itemY*2][itemX*2]/2;
    }
}
