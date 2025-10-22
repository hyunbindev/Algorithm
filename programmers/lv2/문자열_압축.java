//https://github.com/hyunbindev/Algorithm/new/master/programmers/lv2
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            Queue<String> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<=s.length(); j+=i){
                int end = Math.min(j+i, s.length());
                String sub = s.substring(j,end);
                queue.add(sub);
            }
            int cnt = 1;
            //System.out.println(queue);
            String compare = queue.poll();
            while(!queue.isEmpty()){
                String str = queue.poll();
                if(compare.equals(str)){
                    cnt++;
                }else{
                    if(1<cnt) sb.append(cnt);
                    sb.append(compare);
                    compare=str;
                    cnt=1;
                }
            }
            if(1<cnt)sb.append(cnt);
            sb.append(compare);
            //System.out.println(sb.toString());
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
