//https://school.programmers.co.kr/learn/courses/30/lessons/155651
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[] room = new int[getTime("23:59")];
        
        for(String[] time : book_time){
            int s = getTime(time[0]);
            int e = getTime(time[1]);
            
            room[s]+=1;
            if(room.length<=e+10) continue;
            room[e+10]-=1;
        }
        int answer = 0;
        for(int i=1; i<room.length; i++){
            room[i] += room[i-1];
            answer = Math.max(room[i],answer);
        }
        return answer;
    }
    int getTime(String str){
        String[] part = str.split(":");
        int hour = Integer.parseInt(part[0]);
        int min = Integer.parseInt(part[1]);
        return hour*60 + min;
    }
}
