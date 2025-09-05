//https://school.programmers.co.kr/learn/courses/30/lessons/64065
import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(tuple -> tuple.size()));
        
        Set<Integer> set = new HashSet<>();
        
        List<Integer> answer = new ArrayList<>();
        
        for(List<Integer> tuple : parse(s)){
            pq.add(tuple);
        }
        
        while(!pq.isEmpty()){
            for(Integer element :pq.poll()){
                if(!set.contains(element)){
                    answer.add(element);
                    set.add(element);
                }
            }
        }
        return answer;
    }
    List<List<Integer>> parse(String s){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tuple = null;
        String element = "";
        for(int i = 1; i<s.length()-1; i++){
            char c = s.charAt(i);
            switch(c){
                case '{':
                    tuple = new ArrayList<>();
                    break;
                case ',':
                    if(tuple == null) tuple = new ArrayList<>();
                    if(element.length() != 0) tuple.add(Integer.parseInt(element));
                    element = "";
                    break;
                case '}':
                    if(element.length() != 0) tuple.add(Integer.parseInt(element));
                    element="";
                    list.add(tuple);
                    break;
                default:
                    if(element == null) element = new String();
                    element+=c;
                    break;
            }
        }
        return list;
    }
}
