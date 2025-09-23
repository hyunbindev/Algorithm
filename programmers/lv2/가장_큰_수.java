//https://school.programmers.co.kr/learn/courses/30/lessons/42746
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr){
            sb.append(s);
        }
        String a = sb.toString();
        if(a.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
