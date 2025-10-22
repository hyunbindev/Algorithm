//https://school.programmers.co.kr/learn/courses/30/lessons/133500
import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] light;
    boolean[] visit;
    public int solution(int n, int[][] lighthouse) {
        light = new boolean[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] light : lighthouse){
            int u=light[0],v=light[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(1);
        int answer = 0;
        for(boolean l : light)
            if(l)answer++;
        return answer;
    }
    int dfs(int node){
        //System.out.println(node);
        visit[node]=true;
        boolean on = false;
        boolean hasChild = false;
        for(int child : graph.get(node)){
            if(!visit[child] && dfs(child)==0){
                on = true;
                hasChild=true;
            }
        }
        if(!hasChild) return 0;
        if(on){
            light[node]=true;
            return 1;
        };
        return 0;
    }
}
