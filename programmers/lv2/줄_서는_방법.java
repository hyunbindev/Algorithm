//https://school.programmers.co.kr/learn/courses/30/lessons/12936
import java.util.*;
class Solution {
    long k;
    public List<Integer> solution(int n, long k) {
        List<Integer> seq = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++)
            seq.add(i);
        
        this.k = k;
        for(int i=n-1; 0<i; i--){
            long f = factorial(i);
            int s = (int)getSeq(f,this.k);
            answer.add(seq.get(s));
            seq.remove(s);
        }
        answer.add(seq.get(0));
        return answer;
    }
    
    long factorial(long n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }
    
    long getSeq(long f, long k){
        long r = 0;
        for(long i=0; i*f<k; i++){
            r = i;
        }
        this.k-=r*f;
        return r;
    }
}
