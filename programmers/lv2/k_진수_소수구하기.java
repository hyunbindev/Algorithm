//https://school.programmers.co.kr/learn/courses/30/lessons/92335
import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] p = convert(n,k).split("0");
        
        for(String str : p){
            if(str.equals(""))continue;
            if(isPrime(Long.parseLong(str))) answer++;
        }
        
        return answer;
    }
    String convert(int n,int k){
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            sb.append(n%k);
            n/=k;
        }
        return sb.reverse().toString();
    }
    boolean isPrime(long n){
        if(n==1) return false;
        for(int i=2; i<=(int)Math.sqrt(n);i++){
            if(n%i == 0)return false;
        }
        return true;
    }
}
//
//2 10 0
//2 5  1
//2 2  0
//2 1
//
