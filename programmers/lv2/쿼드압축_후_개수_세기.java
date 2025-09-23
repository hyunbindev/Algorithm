//https://school.programmers.co.kr/learn/courses/30/lessons/68936

import java.util.*;
class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        //4분의 1 로 나누어 나가면서 체크해야함
        
        dfs(arr);
        
        return answer;
    }
    void dfs(int[][] arr){
        if(valid(arr)){
            if(arr[0][0] == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
            return;
        }
        //1사분면
        int[][] temp1 = new int[arr.length/2][arr.length/2];
        for(int y = 0; y<arr.length/2; y++){
            for(int x = 0; x<arr.length/2; x++){
                temp1[y][x] = arr[y][x+arr.length/2];
            }
        }
        dfs(temp1);
        //2사분면
        int[][] temp2 = new int[arr.length/2][arr.length/2];
        for(int y = 0; y<arr.length/2; y++){
            for(int x = 0; x<arr.length/2; x++){
                temp2[y][x] = arr[y][x];
            }
        }
        dfs(temp2);
        //3사분면
        int[][] temp3 = new int[arr.length/2][arr.length/2];
        for(int y = 0; y<arr.length/2; y++){
            for(int x = 0; x<arr.length/2; x++){
                temp3[y][x] = arr[y+arr.length/2][x];
            }
        }
        dfs(temp3);
        //4사분면
        int[][] temp4 = new int[arr.length/2][arr.length/2];
        for(int y = 0; y<arr.length/2; y++){
            for(int x = 0; x<arr.length/2; x++){
                temp4[y][x] = arr[y+arr.length/2][x+arr.length/2];
            }
        }
        dfs(temp4);
    }
    boolean valid(int[][] array){
        int n = array[0][0];
        for(int y = 0; y<array.length; y++){
            for(int x = 0; x<array.length; x++){
                if(n != array[y][x]) return false;
            }
        }
        return true;
    }
}
