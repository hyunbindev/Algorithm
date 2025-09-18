//https://school.programmers.co.kr/learn/courses/30/lessons/388353
import java.util.*;
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    char[][] storage;
    int answer = 0;
    public int solution(String[] s, String[] requests) {
        int total = s.length;
        total*=s[0].length();
        
        storage = new char[s.length+2][s[0].length()+2];
        
        for(int i = 0; i<storage.length; i++){
            Arrays.fill(storage[i],'#');
        }
        
        for(int i = 0; i<s.length; i++){
            for(int j = 0; j<s[0].length(); j++){
                storage[i+1][j+1] = s[i].charAt(j);
            }
        }
        
        
        for(String req : requests){
            if(req.length() == 2){
                delete(req.charAt(0));
            }else{
                bfs(req.charAt(0));
            }
        }
        
        
        for(int i =0; i<storage.length; i++){
            for(int j= 0; j<storage[i].length; j++){
                System.out.print(storage[i][j]);
            }
            System.out.println();
        }
        
        for(int i =1; i<storage.length-1; i++){
            for(int j =1; j<storage[i].length-1; j++){
                if(storage[i][j] != '#') answer++;
            }
        }
        
        
        return answer;
    }
    
    void bfs(char c){
        boolean[][] visit = new boolean[storage.length][storage[0].length];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0,0});
        visit[0][0]=true;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int py=p[0], px=p[1];
            if(storage[py][px] == c){
                storage[py][px] = '#';
                continue;
            }
            
            for(int i = 0; i<4; i++){
                int ny = p[0]+dy[i];
                int nx = p[1]+dx[i];
                if(0<=ny && 0<=nx && ny<storage.length && nx<storage[0].length){
                    if(!visit[ny][nx] && (storage[ny][nx] == '#' || storage[ny][nx] == c)){
                        q.add(new int[]{ny,nx});
                        visit[ny][nx] = true;
                    }
                }
            }
        }
    }
    void delete(char c){
        for(int i =0; i<storage.length; i++){
            for(int j =0; j<storage[i].length; j++){
                if(storage[i][j] == c){
                    storage[i][j] = '#';
                }
            }
        }
    }
}
