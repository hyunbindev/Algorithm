//https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] visit = new int[n+1][m+1];
        visit[1][1]=1;
        int answer = 0;
        for(int i =0; i<puddles.length; i++){
            int puddleM = puddles[i][0];
            int puddleN = puddles[i][1];
            visit[puddleN][puddleM] = -1;
        }
        for(int i =1; i<=n; i++){
            for(int k = 1; k<=m; k++){
                if(visit[i][k] == -1) continue;
                
                if(i-1>=0 && visit[i-1][k] != -1) visit[i][k] += visit[i-1][k];
                //시도2 시간초과 => 1000000007 이 넘는지 검사후 나누어 준다
                if(visit[i][k] > 1000000007) visit[i][k] %=1000000007;
                
                if(k-1>=0 && visit[i][k-1] != -1) visit[i][k] += visit[i][k-1]%1000000007;
              
                //시도2 시간초과 => 1000000007 이 넘는지 검사후 나누어 준다
                if(visit[i][k] > 1000000007) visit[i][k] %=1000000007;
            }
        }
        return visit[n][m]%1000000007;
    }
}
