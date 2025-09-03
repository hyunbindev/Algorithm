// https://school.programmers.co.kr/learn/courses/30/lessons/42861
import java.util.*;
class Solution {
    int[] group;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge[2]));
        
        group = new int[n];
        
        for(int i =0; i<group.length; i++){
            group[i] = i;
        }
        
        int edgeCount = 0;
        
        for(int[] cost : costs){
            //시작 종료 비용 정점
            Integer[] edge = { cost[0], cost[1], cost[2] };
            pq.add(edge);
        }
        
        while(!pq.isEmpty() && edgeCount < n-1){
            Integer[] edge = pq.poll();
            Integer node_a = edge[0];
            Integer node_b = edge[1];
            
            if(findParent(node_a) != findParent(node_b)){
                union(node_a, node_b);
                answer += edge[2];
                edgeCount++;
            }
        }
        return answer;
    }
    
    int findParent(int node){
        if(group[node] == node) return node;
        return findParent(group[node]);
    }
    
    void union(int node_a, int node_b){
        int parent_a = findParent(node_a);
        int parent_b = findParent(node_b);
        if(parent_a != parent_b) group[parent_b] = parent_a;
    }
}
