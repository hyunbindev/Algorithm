//https://school.programmers.co.kr/learn/courses/30/lessons/150366
import java.util.*;
class Solution {
    String[][] chart = new String[51][51];
    List<String> answer = new LinkedList<>();
    List<int[]>[][] graph = new List[51][51];
    public List<String> solution(String[] commands) {
        for(int r=1; r<graph.length; r++){
            for(int c=1; c<graph[r].length; c++){
                graph[r][c]=new LinkedList<>();
            }
        }
        
        for(String command : commands){
            String[] com = command.split(" ");
            if(com[0].equals("UPDATE")){
                if(com.length==4) update(Integer.parseInt(com[1]),Integer.parseInt(com[2]),com[3]);
                if(com.length==3) update(com[1],com[2]);
            }
            if(com[0].equals("MERGE"))
                merge(Integer.parseInt(com[1]),Integer.parseInt(com[2]),Integer.parseInt(com[3]),Integer.parseInt(com[4]));
            
            if(com[0].equals("UNMERGE"))
                unMerge(Integer.parseInt(com[1]),Integer.parseInt(com[2]));
            if(com[0].equals("PRINT")){
                int r=Integer.parseInt(com[1]),c=Integer.parseInt(com[2]);
                if(chart[r][c]==null){
                    answer.add("EMPTY");
                    continue;
                }
                answer.add(chart[r][c]);
            }
        }
        
        return answer;
    }
    void update(int r, int c, String value){
        bfs(r,c,value,false);
    }
    void merge(int r1, int c1, int r2, int c2){
        if(r1==r2 && c1==c2) return;
        String value = chart[r1][c1] != null ? chart[r1][c1] : chart[r2][c2];
        graph[r1][c1].add(new int[]{r2,c2});
        graph[r2][c2].add(new int[]{r1,c1});
        bfs(r1,c1,value,false);
    }
    void unMerge(int r, int c){
        String tmp = chart[r][c];
        bfs(r,c,null,true);
        chart[r][c]=tmp;
    }
    void update(String v1, String v2){
        for(int r=1; r<chart.length; r++){
            for(int c=1; c<chart[r].length; c++){
                if(chart[r][c]!= null && chart[r][c].equals(v1)) chart[r][c]=v2;
            }
        }
    }
    void bfs(int r, int c, String value, boolean delete){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[51][51];
        visit[r][c]=true;
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] node = q.poll();
            int y=node[0],x=node[1];
            chart[y][x]=value;
            for(int[] next : graph[y][x]){
                int ny=next[0],nx=next[1];
                if(visit[ny][nx]) continue;
                q.add(next);
                visit[ny][nx]=true;
                chart[ny][nx]=value;
            }
            if(delete) graph[y][x].clear();
        }
    }
}
