//https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        int currentCamera = -30001;
        for(int[] route :routes){
            if(route[0]>currentCamera){
                answer++;
                currentCamera = route[1];
            }
        }
        return answer;
    }
}
