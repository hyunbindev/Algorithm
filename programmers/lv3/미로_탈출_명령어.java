//https://school.programmers.co.kr/learn/courses/30/lessons/150365
import java.util.*;
class Solution {
    int[] dx = {0,-1,1,0};
    int[] dy = {1,0,0,-1};
    char[] dc = {'d','l','r','u'};
    String answer = "";
    int n ,m ,r ,c ,k;
    List<String> orders = new ArrayList<>();
    public String solution(int m, int n, int y, int x, int c, int r, int k) {
        this.n=n;this.m=m;this.r=r;this.c=c;this.k=k;
        
        dfs(x,y,0,"");
        
        if(answer.equals("")) return "impossible";
        
        
        return answer;
    }
    void dfs(int x, int y, int cnt, String str){
        if(!answer.equals(""))return;
        if(x==r && y==c && cnt == k){
            answer = str;
            return;
        }
        int d = Math.abs(x-r)+Math.abs(y-c);
        if(cnt + d > k || (k - cnt - d) % 2 != 0) return;
        
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(0<nx && 0<ny && nx<=n && ny<=m){
                dfs(nx,ny,cnt+1,str+dc[i]);
            }
        }
    }
}
