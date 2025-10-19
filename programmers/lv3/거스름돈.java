//https://school.programmers.co.kr/learn/courses/30/lessons/12907
import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[][] dp = new int[money.length][n+1];
        dp[0][0]=1;
        for(int i=1; i<=n; i++){
            if(i%money[0] ==0){
                dp[0][i]=1;
            }
        }
        
        for(int i=1; i<money.length; i++){
            for(int j=0; j<dp[i].length; j++){
                if(money[i]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-money[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[money.length-1][dp[0].length-1];
    }
}
