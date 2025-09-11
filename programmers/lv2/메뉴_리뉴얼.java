//https://school.programmers.co.kr/learn/courses/30/lessons/72411
import java.util.*;
import java.util.stream.Collectors;
class Solution {
    Map<String,Integer> map = new HashMap<>();
    Map<Integer,Integer> mm = new HashMap<>();
    int[] course;
    public List<String> solution(String[] orders, int[] course) {
        
        this.course = course;
        
        for(int c : course){
            mm.put(c, Integer.MIN_VALUE);
        }
        
        for(int i=0; i<orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            String order = "";
            for(char c : charArr){
                order+=c;
            }
            orders[i] = order;
            dfs(charArr,"",0);
        }
        List<String> answer = new ArrayList<>();
        
        for(Map.Entry<String,Integer> element : map.entrySet()){
            if(element.getValue() == mm.get(element.getKey().length())){
                answer.add(element.getKey());
            }
        }
        Collections.sort(answer);
        return answer;
    }
    
    void dfs(char[] arr, String s, int idx){
        for(int c :course){
            if(c == s.length()){
                if(map.get(s) == null){
                    map.put(s,1);
                    int maxValue = mm.get(c);
                }else{
                    map.put(s,map.get(s)+1);
                    int maxValue = mm.get(c);
                    mm.put(c, Math.max(maxValue,map.get(s)));
                };
            }
        }
        for(int i = idx; i<arr.length; i++){
                String str = s+arr[i];
                dfs(arr,str,i+1);
        }
    }
}
