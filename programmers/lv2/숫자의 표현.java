//https://school.programmers.co.kr/learn/courses/30/lessons/12924
class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        
        while(end <= n){
            if(sum(start,end) == n){
                answer++;
                end++;
                continue;
            }
            if(sum(start,end) < n) end++;
            if(sum(start,end) > n) start++;
        }
        return answer;
    }
    private int sum (int a, int b){
        return (a+b)*(b-a+1)/2;
    }
}
