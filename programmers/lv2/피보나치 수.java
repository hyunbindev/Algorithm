//https://school.programmers.co.kr/learn/courses/30/lessons/12945

class Solution {
    public int solution(int n) {
        return dp(0,1,2,n)%1234567;
    }
    private int dp(int a, int b ,int count, int target){
        int c = (a+b)%1234567;
        if(target == count) return c;
        return dp(b,c,++count,target);
    }
}
