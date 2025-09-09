//https://school.programmers.co.kr/learn/courses/30/lessons/17678

import java.util.*;
class Solution {
    //버스의 사전순
    //그리고 시간의 사전순
    //그냥 마지막 차에서 결정 cnt 가 차있으면 맨늦게온사람 사람보다 1분빨리오면 됨
    List<Shuttle> li = new ArrayList<>();
    PriorityQueue<String> crew = new PriorityQueue<>();
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        li.add(new Shuttle("09:00"));
        
        for(String time : timetable){
            crew.add(time);
        }
        
        for(int i = 1; i<n; i++){
            int hour = Integer.parseInt(li.get(i-1).time.substring(0,2));
            int min = Integer.parseInt(li.get(i-1).time.substring(3,5));
            if(60<=min+t){
                hour++;
            }
            min=(min+t)%60;
            String hh = Integer.toString(hour).length() == 1 ? "0"+Integer.toString(hour) : Integer.toString(hour);
            String mm = Integer.toString(min).length() == 1 ? "0"+Integer.toString(min) : Integer.toString(min);
            //System.out.println(hh+":"+mm);
            li.add(new Shuttle(hh+":"+mm));
        }
        
        
        for(int i = 0; i<li.size(); i++){
            Shuttle shuttle = li.get(i);
            //System.out.println(shuttle.time);
            while(!crew.isEmpty()){
                if(crew.peek().compareTo(shuttle.time)<=0){
                    if(m<=shuttle.p.size()){
                        
                        break;
                    }
                    shuttle.p.add(crew.poll());
                }else{
                    break;
                }
            }
            //System.out.println(shuttle.p);
        }
        Shuttle last = li.get(li.size()-1);
        return last.p.size() < m ? last.time : steal(last.p.get(last.p.size()-1));
    }
    class Shuttle{
        String time;
        List<String> p = new ArrayList<String>();
        Shuttle(String time){
            this.time = time;
        }
    }
    String steal(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        
        if(min-1<0){
            hour--;
            min=59;
        }else{
            min--;
        }
        String hh = Integer.toString(hour);
        String mm = Integer.toString(min);
        if(hh.length() == 1) hh = "0"+hh;
        if(mm.length() == 1) mm = "0"+mm;
        return hh +":"+mm;
    }
}
