//https://school.programmers.co.kr/learn/courses/30/lessons/135807
import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = arrayA[0];
        
        for(int i=1; i<arrayA.length; i++){
            a = gcd(arrayA[i],a);
        }
        
        int b = arrayB[0];
        
        for(int i=1; i<arrayB.length; i++){
            b = gcd(arrayB[i],b);
        }
        
        if(!isDivide(arrayB,a)){
            answer = a;
        }
        
        if(!isDivide(arrayA,b)){
            answer = Math.max(answer,b);
        }
        
        return answer;
    }
    int gcd (int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    boolean isDivide(int[] array, int num){
        for(int a : array){
            if(a%num ==0) return true;
        }
        return false;
    }
}
