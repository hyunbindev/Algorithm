//https://school.programmers.co.kr/learn/courses/30/lessons/12952
import java.util.*;
class Solution {
    boolean[][] board;
    int answer = 0;
    public int solution(int n) {
        board=new boolean[n][n];
        dfs(0);
        return answer;
    }
    void dfs(int depth){
        if(depth==board.length){
            answer++;
            return;
        }
        for(int x=0; x<board[depth].length; x++){
            if(valid(depth,x)){
                board[depth][x]=true;
                dfs(depth+1);
                board[depth][x]=false;
            } 
        }
    }
    boolean valid(int y, int x){
        for(int i=0; i<=y; i++){
            if(board[y-i][x]) return false;
            if(0<=x-i && board[y-i][x-i]) return false;
            if(x+i<board[y-i].length && board[y-i][x+i]) return false;
        }
        return true;
    }
}
