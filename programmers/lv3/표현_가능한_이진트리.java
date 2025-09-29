//https://school.programmers.co.kr/learn/courses/30/lessons/150367
import java.util.*;
class Solution {
    
    public List<Integer> solution(long[] numbers) {
        List<Integer> answer = new LinkedList<>();
        for(long number : numbers){
            String str = Long.toBinaryString(number);
            
            int len = 1;
            
            while(len<str.length()){
                len = len*2 +1;
            }
            StringBuilder sb = new StringBuilder();
            
            for(int i =0; i<len-str.length(); i++){
                sb.append('0');
            }
            sb.append(str);
            str = sb.toString();
            //System.out.println(str);
            if(dfs(str)){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }
        return answer;
    }
    boolean dfs(String str){
        int m = str.length()/2;
        //System.out.println(str);
        if(str.length() == 1) return true;
        //System.out.println(str);
        if(str.charAt(m) == '0'){
            if(str.contains("1")) return false;
               return true;
        };
        String l = str.substring(0,m);
        String r = str.substring(m+1,str.length());
        boolean result = false;
        result = dfs(l) && dfs(r);
        return result;
    }
}
