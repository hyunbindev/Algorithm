//https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;
class Solution {
    List<List<int[]>>graph = new ArrayList<>();
    int n;
    int[] dist;
    public int solution(int n, int[][] roads, int k) {
        int answer = 0;
        this.n = n;
        
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i =0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : roads){
            int u=r[0], v=r[1], d=r[2];
            graph.get(u).add(new int[]{v,d});
            graph.get(v).add(new int[]{u,d});
        }
        djkstra();
        
        //for(int d : dist){
        //    System.out.println(d);
        //}
        
        for(int i =0; i<=n; i++){
            if(dist[i] <= k) answer++;
        }
        
        return answer;
    }
    void djkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            
            if(dist[u] < d) continue;
            
            dist[u] = d;
            
            for(int[] edge : graph.get(u)){
                int v = edge[0], w = edge[1];
                pq.add(new int[]{v, w+d});
            }
        }
    }
}
