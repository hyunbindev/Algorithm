//https://school.programmers.co.kr/learn/courses/30/lessons/17677
import java.util.*;
class Solution {
    Map<String,Integer> map1 = new HashMap<>();
    Map<String,Integer> map2 = new HashMap<>();
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        char[] ca1 = str1.toCharArray();
        char[] ca2 = str2.toCharArray();
        
        for(int i =0; i<ca1.length-1; i++){
            char a = ca1[i];
            char b = ca1[i+1];
            if(!Character.isLetter(a) || !Character.isLetter(b)) continue;
            String s = ""+a+b;
            if(map1.get(s)==null){
                map1.put(s,1);
            }else{
                int cnt = map1.get(s);
                map1.put(s,cnt+1);
            }
        }
        
        for(int i = 0; i<ca2.length-1; i++){
            char a = ca2[i];
            char b = ca2[i+1];
            if(!Character.isLetter(a) || !Character.isLetter(b)) continue;
            String s= ""+a+b;
            if(map2.get(s) == null){
                map2.put(s,1);
            }else{
                int cnt = map2.get(s);
                map2.put(s,cnt+1);
            }
        }
        //System.out.println(map1);
        //System.out.println(map2);
        
        int ic = 0;
        int uc = 0;
        
        for(Map.Entry<String,Integer> element : map1.entrySet()){
            String key = element.getKey();
            int v1 = element.getValue();
            
            Integer v2 = map2.get(key);
            if(v2 == null){
                uc+=v1;
            }else{
                ic+= Math.min(v1,v2);
                uc+= Math.max(v1,v2);
            }
        }
        
        for(Map.Entry<String,Integer> element : map2.entrySet()){
            String key = element.getKey();
            int v2 = element.getValue();
            if(map1.get(key) !=null) continue;
            uc+=v2;
        }
        if(uc == 0) return 65536;
        double answer = (double)ic/(double)uc*65536;
        return (int)answer;
    }
}
