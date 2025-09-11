//https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;
class Solution {
    Map<String,String> parking = new HashMap<>();
    Map<String,Integer> sum = new HashMap<>();
    int[]fees;
    public List<Integer> solution(int[] fees, String[] records) {
        this.fees = fees;
        for(String record : records){
            String time = record.substring(0,5);
            String number = record.substring(6,10);
            String type = record.substring(11,13);
            
            if(type.equals("IN")){
                parking.put(number,time);
            }else{
                String IN_TIME = parking.get(number);
                int minGap = gapMin(IN_TIME,time);
                parking.remove(number);
                if(sum.get(number) == null){
                    sum.put(number, minGap);
                }else{
                    int oldGap = sum.get(number);
                    sum.put(number,minGap+oldGap);
                }
            }
        }
        
        for(Map.Entry<String,String> element : parking.entrySet()){
            String key = element.getKey();
            int gap = gapMin(element.getValue(),"23:59");
            if(sum.get(key) == null){
                sum.put(key,gap);
            }else{
                int oldGap = sum.get(key);
                sum.put(key,oldGap+gap);
            }
        }
        //System.out.println(sum);
        
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b)->{
            return a.number.compareTo(b.number);
        });
        
        List<Integer> answer = new ArrayList<>();
        
        for(Map.Entry<String,Integer> element : sum.entrySet()){
            pq.add(new Info(element.getKey(), element.getValue()));
        }
        
        while(!pq.isEmpty()){
            answer.add(pq.poll().fee);
        }
        
        return answer;
    }
    class Info{
        String number;
        int fee=0;
        Info(String number, int min){
            this.number = number;
            if(min<=fees[0]){
                this.fee = fees[1];
            }else{
                min=min-fees[0];
                this.fee = fees[1];
                if(min%fees[2]>0)this.fee+=fees[3];
                this.fee += (min/fees[2])*fees[3];
            }
        }
    }
    
    int gapMin(String in, String out){
        String in_hh = in.substring(0,2);
        String in_mm = in.substring(3,5);
        //System.out.println(in_mm);
        int in_hour = Integer.parseInt(in_hh);
        int in_min = Integer.parseInt(in_mm);
        
        
        String out_hh = out.substring(0,2);
        String out_mm = out.substring(3,5);
        
        return Integer.parseInt(out_hh)*60 + Integer.parseInt(out_mm) -Integer.parseInt(in_hh)*60 - Integer.parseInt(in_mm);
    }
}
