//https://school.programmers.co.kr/learn/courses/30/lessons/169199
import java.util.*;
class Solution {
    public int solution(String[] board) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visit = new int[board.length][board[0].length()];
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        for(int y=0; y<visit.length; y++){
            for(int x=0; x<visit[y].length; x++){
                visit[y][x]= Integer.MAX_VALUE;
                if(board[y].charAt(x) == 'R'){
                    q.add(new int[]{y,x});
                    visit[y][x] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int y=p[0],x=p[1];
            if(board[y].charAt(x) == 'G') return visit[y][x];
            for(int i =0; i<4; i++){
                int ny=y,nx=x;
                while(0<=ny+dy[i] && 0<=nx+dx[i] && ny+dy[i]<board.length && nx+dx[i]<board[0].length() && board[ny+dy[i]].charAt(nx+dx[i]) !='D'){
                    ny+=dy[i];
                    nx+=dx[i];
                }
                //System.out.print(ny);
                //System.out.println(nx);
                if(visit[y][x]+1<visit[ny][nx]){
                    visit[ny][nx] = visit[y][x]+1;
                    q.add(new int[]{ny,nx});
                }
            }
        }
        
        return -1;
    }
}
