//https://school.programmers.co.kr/learn/courses/30/lessons/12981?language=java
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> hashSet = new HashSet<>();
        int[] answer = {0,0};
        hashSet.add(words[0]);
        for(int i = 1; i<words.length; i++){
            if(hashSet.contains(words[i])){
                //중복단어
                int cycle = i/n+1;
                int turn = i%n+1;
                answer[1] = cycle;
                answer[0] = turn;
                break;
            }
            char[] lastWord = words[i-1].toCharArray();
            char[] currentWord = words[i].toCharArray();
            
            if(!(lastWord[lastWord.length-1] == currentWord[0])){
                //끝단어와 틀리다면
                int cycle = i/n+1;
                int turn = i%n+1;
                answer[1] = cycle;
                answer[0] = turn;
                break;
            }
            hashSet.add(words[i]);
        }
        return answer;
    }
}
