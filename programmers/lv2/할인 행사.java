//https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;
class Solution {
    private static final int window = 10;
    List<String> q = new LinkedList<>();
    String[] want;
    int[] number;
    int answer = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        
        this.want = want;
        this.number = number;
        
        for(int i =0; i<window; i++){
            q.add(discount[i]);
        }
        
for(int i = window; i<discount.length; i++){
            check();
            q.remove(0);
            q.add(discount[i]);
        }
        
        check();
        
        return this.answer;
    }
    public void check(){
        Map<String,Integer> map = new HashMap<>();
        for(String e : q){
            Integer v = map.get(e);
            if(v == null){
                map.put(e,1);
            }else{
                map.put(e, v+1);
            }
        }
        
        for(int i =0; i<want.length; i++){
            Integer v = map.get(want[i]);
            if(v == null || v != number[i]) return;
        }
        answer++;
    }
}
