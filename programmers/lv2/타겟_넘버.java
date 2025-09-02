//https://school.programmers.co.kr/learn/courses/30/lessons/43165
import java.util.*;
class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0,0);
        
        return answer;
    }
    void dfs(int d, int sum){
        if(d == numbers.length){
            if(sum == this.target) answer++;
            return;
        }
        dfs(d+1, sum+numbers[d]);
        dfs(d+1, sum-numbers[d]);
    }
}
