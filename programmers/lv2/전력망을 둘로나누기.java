//https://school.programmers.co.kr/learn/courses/30/lessons/86971
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        for(int i =0; i<=wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            boolean[] visit = new boolean[n+1];
            
            for(int j =0; j<=n; j++){
                graph.add(new LinkedList<>());
            }
            
            for(int j=0; j<wires.length; j++){
                if(j == i) continue;
                int[] edge = wires[j];
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            
            int nodeCount = dfs(1,graph,visit);
            int other = n-nodeCount;
            answer = Math.min(answer, Math.abs(nodeCount-other));
        }
        return answer;
    }
    int dfs(int node, List<List<Integer>> graph, boolean[] visit){
        visit[node] = true;
        int cnt = 1;
        for(int nextNode : graph.get(node)){
            if(!visit[nextNode]) cnt+= dfs(nextNode, graph, visit);
        }
        return cnt;
    }
}
