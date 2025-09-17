//https://school.programmers.co.kr/learn/courses/30/lessons/42583?gad_source=1&gad_campaignid=22366107751&gbraid=0AAAAAC_c4nAEMG8c_GFYQRwsIxAagR3D7&gclid=CjwKCAjwlaTGBhANEiwAoRgXBY8zdhreMH5OMwvfK3qsj96IJl6OshoMb-N89S9DRX9JHYo4CzsMvRoCflcQAvD_BwE
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> w = new LinkedList<>();
        
        for(int truck : truck_weights){
            w.add(truck);
        }
        
        Queue<Integer> b = new LinkedList<>();
        for(int i = 0; i<bridge_length; i++){
            b.add(0);
        }
        int totalWeight = 0;
        int answer = 0;
        while(true){
            answer++;
            totalWeight -= b.poll();
            if(!w.isEmpty() && totalWeight + w.peek() <= weight){
                b.add(w.peek());
                totalWeight+=w.poll();
            }else{
                b.add(0);
            }
            
            if(w.isEmpty() && totalWeight == 0) break;
        }
        return answer;
    }
}
