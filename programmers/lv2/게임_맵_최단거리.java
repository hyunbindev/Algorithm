//https://school.programmers.co.kr/learn/courses/30/lessons/1844
import java.util.*;
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    Queue<Pos> q = new LinkedList<>();
    int[][] visit;
    Pos des;
    int[][] maps;
    public int solution(int[][] maps) {
        this.des = new Pos(maps[0].length-1, maps.length-1);
        this.visit = new int[maps.length][maps[0].length];
        this.maps = maps;
        for(int i=0; i<visit.length; i++){
            for(int j=0; j<visit[i].length; j++){
                visit[i][j] = -1;
            }
        }
        
        visit[0][0] = 1;
        
        addQ(0,0);
        
        
        while(!this.q.isEmpty()){
            Pos cp = q.poll();
            addQ(cp.x,cp.y);
        }
        
        return visit[this.des.y][this.des.x];
    }
    void addQ(int x,int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(-1<nx && nx<=des.x && -1<ny && ny<=des.y && this.maps[ny][nx] == 1){
                if(visit[ny][nx] == -1 || visit[ny][nx] > visit[y][x]+1){
                    this.q.add(new Pos(nx,ny));
                    this.visit[ny][nx] = visit[y][x]+1;
                }
            }
        }
    }
    
    class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
