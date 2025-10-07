//https://school.programmers.co.kr/learn/courses/30/lessons/64062
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        if(stones.length==1) return stones[0];
        int answer = 0;
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for(int i =0; i<stones.length; i++){
            high = Math.max(high,stones[i]);
            low = Math.min(low,stones[i]);
        }
        while(low<high){
            int mid = (high+low)/2;
            if(validate(stones,k,mid)){
                low=mid+1;
                answer = mid;
            }else{
                high=mid;
            }
        }
        return answer;
    }
    boolean validate(int[] stones ,int k ,int middle){
        int p = 0;
        for(int i =0; i<stones.length; i++){
            if(middle<=stones[i]){
                p=0;
            }else{
                p++;
            }
            if(k<=p) return false;
        }
        return true;
    }
}
