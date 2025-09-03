//https://school.programmers.co.kr/learn/courses/30/lessons/132266
import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] w = new int[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        
        Arrays.fill(w, Integer.MAX_VALUE);
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i =0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : roads){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        q.add(destination);
        
        w[destination] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer nx : graph.get(node)){
                if(w[node]+1 < w[nx]){
                    q.add(nx);
                    w[nx] = w[node] + 1;
                }
            }
        }
        int[] answer = new int[sources.length];
        for(int i =0; i<sources.length; i++){
            if(w[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = w[sources[i]];
            }
        }
        return answer;
    }
}
