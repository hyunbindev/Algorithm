//https://school.programmers.co.kr/learn/courses/30/lessons/76503
import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    long[] arr;
    boolean[] visit;
    long answer = 0;
    int[] a;
    public long solution(int[] a, int[][] edges) {
        long sum =0;
        this.a = a;
        arr = new long[a.length];
        for(int i=0; i<a.length; i++) arr[i]=(long)a[i];
        visit = new boolean[a.length];
        for(int n : a)sum+=n;
        if(sum!=0)return answer-1;
        for(int i=0; i<a.length; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            int u=edge[0],v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0);
        return answer;
    }
    long dfs(int node){
        visit[node]=true;
        for(int i=0; i<graph.get(node).size(); i++){
            int nx = graph.get(node).get(i);
            if(visit[nx])continue;
            long r = dfs(nx);
            answer+=(long)Math.abs(r);
            arr[node]+=r;
        }
        return arr[node];
    }
}
