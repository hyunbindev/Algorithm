//https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=java
import java.util.*;
class Solution {
    int n;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        this.n = n;
        String[] answer = new String[n];
        for(int y=0; y<n; y++){
            StringBuilder sb = new StringBuilder();
            boolean[] b1 = toBinary(arr1[y]);
            boolean[] b2 = toBinary(arr2[y]);
            for(int i=0; i<n; i++){
                if(b1[i] || b2[i]){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[y]=sb.toString();
        }
        return answer;
    }
    
    boolean[] toBinary(int number){
        boolean[] result = new boolean[this.n];
        int idx=this.n-1;
        while(number!=0){
            if(number%2==1) result[idx] = true;
            number=number/2;
            idx--;
        }
        
        return result;
    }
}
