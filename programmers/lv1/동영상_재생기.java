//https://school.programmers.co.kr/learn/courses/30/lessons/340213
import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands){
        String answer = "";
        int len = toMin(video_len);
        int os = toMin(op_start);
        int oe = toMin(op_end);
        
        
        int p = toMin(pos);
        if(os<=p && p<=oe)p=oe;
        for(String command: commands){
            if(command.equals("prev")){
                p-=10;
                if(p<0)p=0;
            }
            if(command.equals("next")){
                p+=10;
                if(len<p)p=len;
            }
            if(os<=p && p<=oe)p=oe;
        }
        
        return minToString(p);
    }
    int toMin(String time){
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h*60+m;
    }
    String minToString(int min){
        int h = min/60;
        int m = min%60;
        String hh = Integer.toString(h);
        String mm = Integer.toString(m);
        if(hh.length()==1) hh = "0"+hh;
        if(mm.length()==1) mm = "0"+mm;
        return hh+":"+mm;
    }
}
