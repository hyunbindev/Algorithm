//https://school.programmers.co.kr/learn/courses/30/lessons/72413
import java.util.*;
class Solution {
    List<List<int[]>>graph;
    int n;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>(n+1);
        this.n = n;
        int answer = 0;
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] fare : fares){
            int v = fare[0], u=fare[1], d=fare[2];
            graph.get(v).add(new int[]{u,d});
            graph.get(u).add(new int[]{v,d});
        }
        int[] dist = djkstra(s);
        
        answer = dist[a]+dist[b];
        
        for(int i=1; i<=n; i++){
            if(i == s) continue;
            int temp =dist[i];
            int[] dist_temp = djkstra(i);
            temp+=dist_temp[a];
            temp+=dist_temp[b];
            
            answer = Math.min(answer, temp);
        }
        return answer;
    }
    int[] djkstra(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            if(dist[u]<d) continue;
            dist[u] = d;
            for(int[] edge : graph.get(u)){
                int v = edge[0], w = edge[1];
                if(w+d < dist[v]){
                    pq.add(new int[]{v,w+d});
                    dist[v] = w+d;
                }
            }
        }
        
        return dist;
    }
}
