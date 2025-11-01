//https://school.programmers.co.kr/learn/courses/30/lessons/388351
import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++){
            int sechedule = convertDate(schedules[i]);
            int[] timelog = timelogs[i];
            boolean pass = true;
            for(int d=0; d<timelog.length; d++){
                int date = (d+startday - 1)%7;
                if(date==5 || date==6) continue;
                if(sechedule < timelog[d]){
                    pass=false;
                    break;
                };
            }
            if(pass)answer++;
        }
        
        return answer;
    }
    int convertDate(int time){
        int hour = time/100;
        int min = time%100+10;
        if(60<=min){
            hour++;
            min%=60;
        }
        return hour*100+min;
    }
}
