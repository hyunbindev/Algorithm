//https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.*;
class Solution {
    //bfs 구만
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[y+1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        
        visit[x] = 0;
        
        q.add(x);
        
        while(!q.isEmpty()){
            //더한거
            int p = q.poll();
            if(p+n < visit.length && visit[p]+1<visit[p+n]){
                visit[p+n] = visit[p]+1;
                q.add(p+n);
            }
            if(p*2 < visit.length && visit[p]+1<visit[p*2]){
                visit[p*2] = visit[p]+1;
                q.add(p*2);
            }
            if(p*3 < visit.length && visit[p]+1<visit[p*3]){
                visit[p*3] = visit[p]+1;
                q.add(p*3);
            }
        }
        return visit[y] == Integer.MAX_VALUE ? -1 : visit[y];
    }
}
