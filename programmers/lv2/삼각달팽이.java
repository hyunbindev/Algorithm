//https://school.programmers.co.kr/learn/courses/30/lessons/68645
import java.util.*;
class Solution {
    int y=-1;
    int x=0;
    int phase=0;
    int a;
    int cnt=1;
    public List<Integer> solution(int n) {
        
        List<Integer> answer = new ArrayList<>();
        int[][] arr = new int[n][];
        a=n;
        
        for(int i=0; i<n; i++){
            arr[i] = new int[i+1];
        }
        
        for(int i=1; i<=(n+1)*n/2; i++){
            cnt++;
            if(phase%3==0) y++;
            if(phase%3==1) x++;
            if(phase%3==2){
                y--;
                x--;
            }
            
            arr[y][x]=i;
            
            if(a<cnt){
                phase++;
                a--;
                cnt=1;
            }
            
        }
        for(int[] ar : arr){
            for(int a : ar) answer.add(a);
        }
        return answer;
    }
}
