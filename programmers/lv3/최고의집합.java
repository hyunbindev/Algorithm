//https://school.programmers.co.kr/learn/courses/30/lessons/12938

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        //시도 2. n이 s보다 클때의 경우의수를 생각하지 못했음
        if(s == 1 || n>s) return new int[]{-1};
        int a = s/n;
        int[] answer = new int[n];
        Arrays.fill(answer,a);
        
        for(int i =0; i<s%n; i++){
            answer[answer.length - i-1]++;
        }
        return answer;
    }
}
