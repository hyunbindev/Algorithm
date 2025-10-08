//https://school.programmers.co.kr/learn/courses/30/lessons/150368
import java.util.*;
class Solution {
    List<int[]> l = new ArrayList<>();
    int[] ratio = {10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        pe(0, new int[emoticons.length]);
        for(int[] ratio : l){
            int cnt=0, sum=0;
            for(int[] user : users){
                int money=0;
                for(int i=0; i<ratio.length; i++){
                    if(user[0]<=ratio[i]){
                        int price = emoticons[i];
                        price-=price*ratio[i]/100;
                        money+=price;
                        if(user[1]<=money){
                            cnt++;
                            money=0;
                            break;
                        }
                    }
                }
                sum+=money;
            }
            if (cnt > answer[0] || (cnt == answer[0] && sum > answer[1])) {
                answer[0] = cnt;
                answer[1] = sum;
            }
        }
        return answer;
    }
    void pe(int d, int[] ratio){
        if(ratio.length==d){
            l.add(ratio.clone());
            return;
        }
        for(int i=0; i<this.ratio.length; i++){
            ratio[d]=this.ratio[i];
            pe(d+1, ratio);
        }
    }
}
