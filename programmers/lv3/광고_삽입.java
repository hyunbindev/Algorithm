//https://school.programmers.co.kr/learn/courses/30/lessons/72414

import java.util.*;
class Solution {
    String answer = "";
    public String solution(String play_time, String adv_time, String[] logs) {
        long[] timeLine = new long[stringToSec(play_time)+1];
        
        for(String log : logs){
            String[] part = log.split("-");
            int s = stringToSec(part[0]);
            int e = stringToSec(part[1]);
            timeLine[s]+=1;
            timeLine[e]-=1;
        }
        
        for(int i =1; i<timeLine.length; i++){
            timeLine[i]+=timeLine[i-1];
        }
        
        long view = 0;
        int time = 0;
        
        int ad_len = stringToSec(adv_time);
        
        for(int i =0; i<ad_len; i++){
            view+=timeLine[i];
        }
        
        long sum = view;
        
        for(int i = 0; i<=stringToSec(play_time)-ad_len; i++){
            sum-=timeLine[i];
            sum+=timeLine[i+ad_len];
            if(view < sum){
                view = sum;
                time = i+1;
            }
        }
        return secToString(time);
    }
    int stringToSec(String str){
        String[] part = str.split(":");
        int hour = Integer.parseInt(part[0]);
        int min = Integer.parseInt(part[1]);
        int sec = Integer.parseInt(part[2]);
        return sec + min*60 + hour*3600;
    }
    
    String secToString(int input){
        int hour = input / 3600;
        input %= 3600;
        int min = input/60;
        input %= 60;
        return String.format("%02d:%02d:%02d",hour,min,input);
    }
}
