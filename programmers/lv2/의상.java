//https://school.programmers.co.kr/learn/courses/30/lessons/42578
import java.util.*;

class Solution {
    //걍 경우의 수 다 구해서 아무것도 안입은거 빼면 되는거 아님? 될듯?
    public int solution(String[][] clothes) {
        Map<String,List<String>> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            String key = cloth[1];
            String value = cloth[0];
            if(map.get(key) == null){
                List<String> li = new ArrayList<>();
                li.add(value);
                map.put(key,li);
            }else{
                map.get(key).add(value);
            }
        }
        int cnt = 1;
        for(List<String> list : map.values()){
            System.out.println(list.size());
            cnt *= list.size()+1;
        }
        return cnt-1;
    }
}
