//https://school.programmers.co.kr/learn/courses/30/lessons/140108
import java.util.*;
class Solution {
    int answer=0;
    public int solution(String s) {
        char[] chars = s.toCharArray();
        
        split(chars);
        
        return answer;
    }
    void split(char[] arr){
        if(arr.length == 1){
            answer++;
            return;
        }
        if(arr.length == 0) return;
        int s = 1;
        int d = 0;
        char first = arr[0];
        for(int i=1; i<arr.length; i++){
            if(first == arr[i]){
                s++;
                continue;
            }
            d++;
            if(s==d){
                split(Arrays.copyOfRange(arr,i+1,arr.length));
                answer++;
                return;
            }
        }
        answer++;
    }
}
