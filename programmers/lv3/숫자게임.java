//https://school.programmers.co.kr/learn/courses/30/lessons/12987

import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> apq = new PriorityQueue<>();
        PriorityQueue<Integer> bpq = new PriorityQueue<>();
        Arrays.sort(A);
        for(int i = 0; i < B.length; i++){
            apq.add(A[i]);
            bpq.add(B[i]);
        }
        while(!bpq.isEmpty()){
            int b = bpq.poll();
            if(apq.peek() >= b) continue;
            apq.poll();
            answer++;
        }
        return answer;
    }
}
