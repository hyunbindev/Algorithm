//https://school.programmers.co.kr/learn/courses/30/lessons/42888
import java.util.*;
class Solution {
    Map<String,String> map = new HashMap<>();
    public List<String> solution(String[] records) {
        List<String> answer = new ArrayList<>();
        List<String[]> logs = new ArrayList<>();
        
        for(String record : records){
            String[] arr = record.split(" ");
            logs.add(new String[]{arr[0],arr[1]});
            switch(arr[0]){
                case "Enter":
                    if(map.get(arr[1])==null){
                        map.put(arr[1],arr[2]);
                    }else{
                        map.put(arr[1],arr[2]);
                    }
                    break;
                case "Change":
                    map.put(arr[1],arr[2]);
                    break;
            }
        }
        for(String[] log : logs){
            String nickname = map.get(log[1]);
            if(log[0].equals("Enter")){
                answer.add(nickname+"님이 들어왔습니다.");
            }
            if(log[0].equals("Leave")){
                answer.add(nickname+"님이 나갔습니다.");
            }
        }
        return answer;
    }
}
