//https://school.programmers.co.kr/learn/courses/30/lessons/12913

import java.util.*;
class Solution {
    //각 행의 최대값을 구한다
    int solution(int[][] land) {
        int[][] cost = new int[land.length][land[0].length];
        cost[0] = land[0];
        for(int i =1; i<land.length; i++){
            for(int r =0; r<4; r++){
                int max = 0;
                for(int k = 0; k<4; k++){
                    if(r != k) max =Math.max(max, cost[i-1][k]);
                }
                cost[i][r] = max + land[i][r];
            }
        }
        int answer = 0;
        for(int e : cost[cost.length-1]){
            answer = Math.max(answer, e);
        }
        return answer;
    }
}
