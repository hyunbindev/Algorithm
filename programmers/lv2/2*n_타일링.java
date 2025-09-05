//https://school.programmers.co.kr/learn/courses/30/lessons/12900

import java.util.*;
class Solution {
    //dp 이고 가면서 저장해 나가야함
    int[] dp;
    public int solution(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        
        return dp[n];
    }
}
