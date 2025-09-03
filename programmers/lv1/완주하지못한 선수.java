//https://school.programmers.co.kr/learn/courses/30/lessons/42576
import java.util.*; 
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String c : completion){
            Integer value = map.get(c);
            if(value == null){
                map.put(c,1);
            }else{
                map.put(c,value+1);
            }
        }
        
        for(String p : participant){
            Integer value = map.get(p);
            if(value == null || value == 0) return p;
            
            map.put(p,value-1);
        }
        return "";
    }
}
