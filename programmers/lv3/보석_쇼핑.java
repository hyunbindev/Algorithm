//https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;
class Solution {
    Map<String,Integer> map = new HashMap<>();
    int cnt;
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        
        for(String gem : gems){
            set.add(gem);
        }
        if(set.size() == 2) return new int[]{1,2};
        cnt = set.size();
        
        int[] answer = {1,gems.length};
        int l=0;
        int r=0;
        while (r < gems.length) {
            addGem(gems[r]);

            // 모든 보석이 들어온 순간
            while (map.size() == cnt) {
                // 최소 구간 갱신
                if (r - l < answer[1] - answer[0]) {
                    answer[0] = l + 1; // 1-based
                    answer[1] = r + 1;
                }
                removeGem(gems[l]);
                l++;
            }
            r++;
        }
        return answer;
    }
    void addGem(String gem){
        if(map.get(gem) == null){
            map.put(gem,1);
        }else{
            int c = map.get(gem);
            map.put(gem,c+1);
        }
    }
    
    void removeGem(String gem){
        if(map.get(gem) == null) return;
        if(map.get(gem) == 1){
            map.remove(gem);
        }else{
            int c = map.get(gem);
            map.put(gem, c-1);
        }
    }
}
