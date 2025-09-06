//https://school.programmers.co.kr/learn/courses/30/lessons/77486
import java.util.*;
class Solution {
    // 상향식으로 가되 돈이 0원일 경우 올리지 않는다
    Map<String,String> graph = new HashMap<>();
    Map<String,Integer> money = new HashMap<>();
    int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i =0; i<enroll.length; i++){
            if(graph.get(enroll[i]) == null){
                graph.put(enroll[i],referral[i]);
            };
        }
        for(String e : graph.keySet()){
            money.put(e,0);
        }
        
        answer = new int[enroll.length];
        
        //한개당 100원
        for(int i =0; i<seller.length; i++){
            dfs(seller[i],amount[i]*100);
        }
        
        for(int i =0; i<answer.length; i++){
            answer[i] = money.get(enroll[i]);
        }
        
        return answer;
    }
    void dfs(String enroll, int money){
        
        int m = this.money.get(enroll);
        
        this.money.put(enroll, m + (money-(money/10)));
        
        
        if(graph.get(enroll).equals("-")) return;
        
        if(money/10<1) return;
        dfs(graph.get(enroll), money/10);
    }
}
