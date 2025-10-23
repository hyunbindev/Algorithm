//https://school.programmers.co.kr/learn/courses/30/lessons/64061
import java.util.*;
class Solution {
    Stack<Integer> stack = new Stack<>();
    int answer =0;
    public int solution(int[][] board, int[] moves) {
        for(int move : moves){
            int depth = 0;
            while(depth<board.length && board[depth][move-1]==0) depth++;
            if(depth==board.length)continue;
            int pick = board[depth][move-1];
            board[depth][move-1]=0;
            pushStack(pick);
        }
        
        return answer;
    }
    void pushStack(int n){
        if(stack.isEmpty()){
            stack.add(n);
            return;
        }
        if(stack.peek()==n){
            stack.pop();
            answer+=2;
            return;
        }
        stack.add(n);
    }
}
