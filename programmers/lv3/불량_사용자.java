//https://school.programmers.co.kr/learn/courses/30/lessons/64064?language=java
import java.util.*;
//일단 완전 탐색인거 같은데
class Solution {
    List<List<String>> graph = new ArrayList<>();
    int answer = 0;
    List<Set<String>> keys = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        for(int i=0; i<banned_id.length; i++){
            keys.add(new HashSet<>());
            graph.add(new ArrayList<>());
            for(String id :user_id){
                boolean result = valid(id,banned_id[i]);
                if(result) graph.get(i).add(id);
            }
        }
        dfs(new HashSet<>(), 0);
        return answer;
    }
    boolean valid(String id, String ban){
        if(id.length() != ban.length()) return false;
        for(int i = 0; i<id.length(); i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != id.charAt(i)) return false;
        }
        return true;
    }
    void dfs(Set<String> set, int idx){
        if(idx == graph.size()){
            for(Set<String> ss : keys){
                if(ss.containsAll(set)) return;
            }
            keys.add(set);
            answer++;
            return;
        };
        List<String> list = graph.get(idx);
        for(String id : list){
            if(set.contains(id)) continue;
            Set<String> temp = new HashSet<>(set);
            temp.add(id);
            dfs(temp, idx+1);
        }
    }
}
