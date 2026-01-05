import java.util.*;
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(char x : X.toCharArray()){
            int num = Integer.parseInt(String.valueOf(x));
            Integer numCount = map.get(num);
            if(numCount == null){
                map.put(num,1);
                continue;
            }
            map.put(num,++numCount);
        }
        
        for(char x : Y.toCharArray()){
            int num = Integer.parseInt(String.valueOf(x));
            Integer numCount = map.get(num);
            
            if(numCount == null || numCount ==0) continue;
            
            map.put(num,--numCount);
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            if(sb.length()==1 && sb.charAt(0)=='0'&&pq.peek()==0){
                pq.poll();
                continue;
            }
            sb.append(pq.poll());
        }
        
        if(sb.length()==0) return "-1";
        
        return sb.toString();
    }
}
