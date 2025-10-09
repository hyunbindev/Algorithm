//https://school.programmers.co.kr/learn/courses/30/lessons/12920
import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int time=0;
        int work=0;
        int l=0,h=n*10000;
        while(l<=h){
            int m =(l+h)/2,task=cores.length;
            for(int core:cores) task+=m/core;
            if(task<n){
                work=task;
                time=m;
                l=m+1;
            }else{
                h=m-1;
            }
        }
        time++;
        for(int i=0; i<cores.length; i++){
            if(time%cores[i]==0){
                work++;
                if(work==n)return i+1;
            }
        }
        return answer;
    }
}
