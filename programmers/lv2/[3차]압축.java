//https://school.programmers.co.kr/learn/courses/30/lessons/17684

import java.util.*;
class Solution {
    List<Integer>answer = new LinkedList<>();
    Map<String,Integer> map = new HashMap<>();
    int idx = 27;
    public List<Integer> solution(String msg) {
        for(int i = 1; i<=26; i++){
            StringBuilder sb = new StringBuilder();
            sb.append((char)(i+64));
            map.put(sb.toString(),i);
        }
        Queue<Character> q = new LinkedList<>();
        for(char c : msg.toCharArray()){
            q.add(c);
        }
        while(!q.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append(q.poll());
            String target = sb.toString();
            while(map.get(sb.toString())!=null && !q.isEmpty()){
                sb.append(q.peek());
                if(map.get(sb.toString())==null){
                    map.put(sb.toString(),idx++);
                    break;
                }
                q.poll();
                target = sb.toString();
            }
            //System.out.println(target);
            answer.add(map.get(target));
        }
        return answer;
    }
}
