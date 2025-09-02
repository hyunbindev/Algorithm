//https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;
class Solution {
    //단순 bfs 아닌감
    public int solution(int n, int[][] edges) {
        //node 번호랑 배열 idx 맞추기 위해
        Integer[] visit = new Integer[n+1];
        
        //방문하지 않은 노드 기록
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[0] = Integer.MAX_VALUE;
        
        //graph
        List<List<Integer>> graph = new ArrayList<>();
        
        //bfs 할꺼니까 queue
        Queue<Integer> q = new LinkedList<>();
        
        //graph 초기화
        for(int i =0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        //간선정보 그래프에 저장
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //bfs 시작 초기 node 1 번 부터 시작
        q.add(1);
        visit[1] = 0;
        
        while(!q.isEmpty()){
            //queue 에서 꺼내옴
            int node = q.poll();
            
            //그래프 간선 정보 순회
            for(int next : graph.get(node)){
                
                //다음 방문할 노드의 거리가 지금 노드에서 출발하면 최단 거리 일경우
                if(visit[node]+1 < visit[next]){
                    
                    //현상태에서 최단 거리 기록
                    visit[next] = visit[node]+1;
                    
                    //다음 node 큐에 넣음
                    q.add(next);
                }
            }
        }
        //bfs 끝났고 제일 먼 노드 찾기 내림 차순 정렬하고
        Arrays.sort(visit, Collections.reverseOrder());
        int max = 0;
        for(int i = 1; i<=n; i++){
            if(visit[i] != Integer.MAX_VALUE){
                max= Math.max(max, visit[i]);
            }
        }
        int answer = 0;
        
        for(int v : visit){
            if(v == max) answer++;
        }
        return answer;
    }
}
