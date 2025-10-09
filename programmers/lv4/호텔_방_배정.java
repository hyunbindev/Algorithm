//https://school.programmers.co.kr/learn/courses/30/lessons/64063
import java.util.*;
class Solution {
    Map<Long,Long> map = new HashMap<>();
    public List<Long> solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        for(long room : room_number){
            if(map.get(room)==null){
                map.put(room,room+1);
                answer.add(room);
            }else{
                answer.add(dfs(room));
            }
        }
        return answer;
    }
    Long dfs(Long room){
        if(map.get(room)==null){
            map.put(room,room+1);
            return room;
        }
        Long a = dfs(map.get(room));
        map.put(room,a);
        return a;
    }
}
