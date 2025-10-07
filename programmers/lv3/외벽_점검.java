//https://github.com/hyunbindev/Algorithm/new/master/programmers/lv3
import java.util.*;
class Solution {
    boolean[] visit;
    int[] dist;
    List<int[]> permutations = new ArrayList<>();
    public int solution(int n, int[] weak, int[] dist) {
        int answer = Integer.MAX_VALUE;
        this.visit = new boolean[dist.length];
        this.dist = dist;
        getPermutation(0, new int[dist.length]);
        
        int[] wall = new int[weak.length*2];
        for(int i=0; i<weak.length; i++){
            wall[i] = weak[i];
        }
        for(int i=weak.length; i<wall.length; i++){
            wall[i] = weak[i%weak.length]+n;
        }
        
        for(int i=0; i<weak.length; i++){
            for(int[] perm : permutations){
                int pos = Integer.MIN_VALUE;
                int ans = 0;
                for(int j=0; j<weak.length; j++){
                    int t = wall[i+j];
                    if(pos < t){
                        if(perm.length-1<ans){
                            ans=Integer.MAX_VALUE;
                            break;
                        };
                        pos = t+perm[ans];
                        ans++;
                    }
                }
                answer = Math.min(ans,answer);
            }
        }
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    void getPermutation(int depth, int[] p){
        if(depth == p.length){
            permutations.add(p);
            return;
        }
        for(int i=0; i<p.length; i++){
            if(visit[i]) continue;
            int[] tmp = p.clone();
            tmp[depth] = dist[i];
            visit[i]=true;
            getPermutation(depth+1, tmp);
            visit[i]=false;
        }
    }
}
