//https://school.programmers.co.kr/learn/courses/30/lessons/43164
import java.util.*;
class Solution {
    Map<String,List<String>> graph = new HashMap<>();
    String[][] tickets;
    List<String> answer = new ArrayList<>();
    public List<String> solution(String[][] tickets) {
        this.tickets = tickets;
        for(String[] ticket : tickets){
            String deperture = ticket[0];
            String arrive = ticket[1];
            
            if(graph.get(deperture) == null) this.graph.put(deperture, new ArrayList<>());
            List<String> arrives = this.graph.get(deperture);
            
            arrives.add(arrive);
            Collections.sort(arrives);
        }
        
        return dfs("ICN",0,answer);
    }
    
    List<String> dfs(String deperture, int cnt, List<String> answer){
        answer.add(deperture);
        if(cnt == tickets.length){
            return answer;
        }
        if(graph.get(deperture)==null || graph.get(deperture).size() == 0){
            answer.remove(answer.size()-1);
            return null;
        };
        for(int i =0; i<this.graph.get(deperture).size(); i++){
            List<String> arrives = this.graph.get(deperture);
            //flag
            String flag = arrives.get(i);
            arrives.remove(i);
            //recursive
            List<String> result = dfs(flag, cnt+1, answer);
            if(result != null){
                return result;
            }else{ 
                //back tracking
                arrives.add(flag);
                Collections.sort(arrives);    
            }
        }
        answer.remove(answer.size()-1);
        return null;
    }
}
