//https://school.programmers.co.kr/learn/courses/30/lessons/92343
import java.util.*;
class Solution {
    List<List<Integer>>graph;
    int[]info;
    int answer = 0;
    Stack<Status> stack = new Stack<>();
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.graph = new ArrayList<>();
        for(int i =0; i<info.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        
        System.out.println(graph);
        
        dfs(new Status(new int[]{1,0}, this.graph.get(0)));
        
        return this.answer;
    }
    
    void dfs(Status status){
        this.stack.add(status);
        this.answer = Math.max(status.stat[0], answer);
        
        for(int i =0; i<status.node.size(); i++){
            Status nextStatus = status.getNextStatus(status.node.get(i));
            if(nextStatus.stat[0]>nextStatus.stat[1]) dfs(nextStatus);
        }
        if(this.stack.isEmpty()) return;
        this.stack.pop();
    }
    
    class Status{
        int[] stat;
        List<Integer>node = new ArrayList<>();
        Status(int[] stat, List<Integer>node){
            this.stat = stat;
            
            for(Integer n : node){
                this.node.add(n);
            }
        }
        
        Status getNextStatus(Integer nextNode){
            int[] stat = new int[2];
            if(info[nextNode] == 0){
                stat[0] = this.stat[0]+1;
                stat[1] = this.stat[1];
            }else{
                stat[0] = this.stat[0];
                stat[1] = this.stat[1]+1;
            }
            List<Integer>nextNodes = new ArrayList<>();
            
            for(Integer nx : this.node){
                if(nx != nextNode) nextNodes.add(nx);
            }
            
            for(Integer nx : graph.get(nextNode)){
                nextNodes.add(nx);
            }
            
            return new Status(stat,nextNodes);
        }
    }
}
