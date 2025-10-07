//https://school.programmers.co.kr/learn/courses/30/lessons/118669
import java.util.*;
class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        Arrays.fill(answer, Integer.MAX_VALUE);
        Arrays.sort(summits);
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        Set<Integer> g = new HashSet<>();
        Set<Integer> s = new HashSet<>();
        for(int gate : gates) g.add(gate);
        for(int summit : summits) s.add(summit);
        
        for(int[] path : paths){
            int u=path[0],v=path[1],w=path[2];
            if(g.contains(u)){
                graph.get(u).add(new int[]{v,w});
                continue;
            }
            if(g.contains(v)){
                graph.get(v).add(new int[]{u,w});
                continue;
            }
            if(s.contains(u)){
                graph.get(v).add(new int[]{u,w});
                continue;
            }
            if(s.contains(v)){
                graph.get(u).add(new int[]{v,w});
                continue;
            }
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int gate : g){
            pq.add(new int[]{gate,0});
            dist[gate]=0;
        }
        
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int v=e[0],w=e[1];
            if(dist[v]<w)continue;
            for(int[] next : graph.get(v)){
                if(dist[next[0]] <= Math.max(dist[v],next[1]))continue;
                dist[next[0]] = Math.max(dist[v],next[1]);
                pq.add(new int[]{next[0],Math.max(dist[v],next[1])});
            }
        }
        for(int summit : summits){
            if(answer[1]>dist[summit]){
                answer[0]=summit;
                answer[1]=dist[summit];
            }
        }
        return answer;
    }
}
