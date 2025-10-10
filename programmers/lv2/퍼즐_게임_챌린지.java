//https://github.com/hyunbindev/Algorithm/new/master/programmers/lv2
import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        for(int diff:diffs)
            answer = Math.max(answer,diff);
        int l = 1;
        int r = answer;
        while(l<=r){
            int m=(l+r)/2;
            long time=(long)times[0];
            for(int i=1; i<diffs.length; i++){
                if(diffs[i]<=m){
                    time+=(long)times[i];
                }else{
                    long wrongCount = diffs[i] - m;
                    time += wrongCount * (times[i] + times[i - 1]) + times[i];
                }
            }
            if(time<=limit){
                r=m-1;
                answer=m;
            }else{
                l=m+1;
            }
        }
        return answer;
    }
}
