//https://school.programmers.co.kr/learn/courses/30/lessons/132265
import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] topping) {
        Map<Integer, Integer> hashLeft = new HashMap<>();
        Map<Integer, Integer> hashRight = new HashMap<>();
        for(int i =0; i<topping.length; i++){
            if(hashRight.get(topping[i]) == null){
                hashRight.put(topping[i],1);
            }else{
                hashRight.put(topping[i],hashRight.get(topping[i])+1);
            }
        }
        for(int i=0; i<topping.length; i++){
            Integer rightTopping = hashRight.get(topping[i]);
            if(rightTopping == 1){
                hashRight.remove(topping[i]);
            }else{
                hashRight.put(topping[i], hashRight.get(topping[i])-1);
            }
            if(hashLeft.get(topping[i]) == null){
                hashLeft.put(topping[i],1);
            }else{
                hashLeft.put(topping[i], hashLeft.get(topping[i])+1);
            }
            if(hashLeft.size() == hashRight.size()) answer++;
        }
        return answer;
    }
}
