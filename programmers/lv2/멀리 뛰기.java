//https://school.programmers.co.kr/learn/courses/30/lessons/12914
class Solution {
    
    public long solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        long[] w = new long[n+1];
        w[1]=1;
        w[2]=2;
        for(int i =3; i<=n; i++){
            w[i] = (w[i-1]+w[i-2])%1234567;
        }
        return w[n];
    }
}
