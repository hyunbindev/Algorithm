//https://school.programmers.co.kr/learn/courses/30/lessons/92344
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] w = new int[board.length+1][board[0].length+1];
        
        for(int[] s : skill){
            int t=s[0],r1=s[1],c1=s[2],r2=s[3],c2=s[4],d=s[5];
            if(t==1) d*=-1;
            w[r1][c1]+=d;
            w[r1][c2+1]-=d;
            w[r2+1][c1]-=d;
            w[r2+1][c2+1]+=d;
        }
        
        for(int y=0; y<w.length; y++){
            for(int x=1;x<w[y].length; x++){
                w[y][x]+=w[y][x-1];
            }
        }
        for(int x=0; x<w[0].length; x++){
            for(int y=1;y<w.length; y++){
                w[y][x]+=w[y-1][x];
            }
        }
        int answer = 0;
        for(int y=0; y<board.length; y++){
            for(int x=0;x<board[y].length; x++){
                if(0<w[y][x]+board[y][x])answer++;
            }
        }
        return answer;
    }
}
