//https://school.programmers.co.kr/learn/courses/30/lessons/131703
import java.util.*;
class Solution {
    List<boolean[]> li = new ArrayList<>();
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        cont(0,new boolean[10]);
        int cnt=0;
        for(int i=0; i<li.size(); i++){
            for(int j=0; j<li.size(); j++){
                boolean[] col = li.get(i);
                boolean[] row = li.get(j);
                boolean pass = true;
                for(int y=0; y<beginning.length; y++){
                    for(int x=0; x<beginning[y].length; x++){
                        int b = col[y]==row[x] ? beginning[y][x] : inverse(beginning[y][x]);
                        if(b!=target[y][x]){
                            pass=false;
                            break;
                        }
                    }
                }
                if(pass){
                    int tmp=0;
                    for(int a=0; a<col.length; a++){
                        if(col[a])tmp++;
                        if(row[a])tmp++;
                    }
                    answer= Math.min(tmp,answer);
                }
            }
        }
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    void cont(int depth, boolean[] arr) {
        if (depth == arr.length) {
            li.add(arr.clone());
            return;
        }
        arr[depth] = false;
        cont(depth + 1, arr);
        arr[depth] = true;
        cont(depth + 1, arr);
    }
    int inverse(int v){
        if(v==1) return 0;
        return 1;
    }
}
