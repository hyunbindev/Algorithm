//https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java
import java.util.*;
class Solution {
    //이겼을때 단방향 그래프 탐색할 수 있는 수 +
    //졌을때 단방향 그래프 탐색할 수 있는 노드 수
    // = n-1; 이 되면됨
  
    List<Integer>[] wg;
    List<Integer>[] lg;
    public int solution(int n, int[][] results) {
        int answer = 0;
        wg = new List[n+1];
        lg = new List[n+1];
        for(int i = 0; i<=n; i++){
            wg[i] = new ArrayList<>();
            lg[i] = new ArrayList<>();
        }
        
        for(int[] edge : results){
            wg[edge[0]].add(edge[1]);
            lg[edge[1]].add(edge[0]);
        }
        
        for(int i =1; i<=n; i++){
            int wc = dfs(wg, i , new boolean[n+1])-1;
            int lc = dfs(lg, i , new boolean[n+1])-1;
            if(wc+lc == n-1) answer++;
        }
        
        return answer;
    }
    
    int dfs(List<Integer>[] graph, int node, boolean[] visit){
        
        if(visit[node]) return 0;
        visit[node] = true;
        List<Integer> edges = graph[node];
        int sum = 1;
        for(Integer edge : edges){
            sum += dfs(graph, edge, visit);
        }
        return sum;
    }
}
