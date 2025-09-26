//https://school.programmers.co.kr/learn/courses/30/lessons/1832

import java.util.*;
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        //세로
        dp[0][0][0]=1;
        //가로
        
        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(cityMap[y][x] == 1)continue;
                if(cityMap[y][x] == 0){
                    if(y+1<m) dp[y+1][x][0]=(dp[y+1][x][0]+dp[y][x][0]+dp[y][x][1])%MOD;
                    if(x+1<n) dp[y][x+1][1]=(dp[y][x+1][1]+dp[y][x][0]+dp[y][x][1])%MOD;
                }
                if(cityMap[y][x] ==2){
                    if(y+1<m){
                        dp[y+1][x][0] = (dp[y+1][x][0]+dp[y][x][0])%MOD;
                    }
                    if(x+1<n){
                        dp[y][x+1][1]= (dp[y][x+1][1]+dp[y][x][1])%MOD;
                    }
                }
            }
        }
        //return 0;
        //System.out.println(dp[m-1][m-1][0]);
        

        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
    }
}
