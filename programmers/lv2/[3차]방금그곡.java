//https://school.programmers.co.kr/learn/courses/30/lessons/17683

import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        m = replace(m);
        
        String answer = "(None)";
        int answerLength = 0;
        for(String music : musicinfos){
            String[] info = music.split(",");
            int len = convertTime(info[1]) - convertTime(info[0]);
            String title = info[2];
            String melody = replace(info[3]);
            //System.out.println(melody);
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i<len; i++){
                sb.append(melody.charAt(i%melody.length()));
            }
            
            melody = sb.toString();
            if(melody.contains(m) && answerLength<melody.length()){
                answer = title;
                answerLength = melody.length();
            }
        }
        return answer;
    }
    String replace(String str){
        return str.replaceAll("A#","a")
            .replaceAll("B#","b")
            .replaceAll("C#","c")
            .replaceAll("D#","d")
            .replaceAll("E#","e")
            .replaceAll("F#","f")
            .replaceAll("G#","g");
    }
    
    int convertTime(String str){
        String[] part = str.split(":");
        return Integer.parseInt(part[0])*60 + Integer.parseInt(part[1]);
    }
}
