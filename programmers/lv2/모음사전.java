//https://school.programmers.co.kr/learn/courses/30/lessons/84512

import java.util.*;
class Solution {
    char[] arr = new char[]{'A','E','I','O','U'};
    int answer = 0;
    int cnt=0;
    String word;
    public int solution(String word) {
        this.word = word;
        dfs("");
        return answer;
    }
    void dfs(String str){
        if(0<str.length())cnt++;
        if(str.equals(word)){
            answer = cnt;
            return;
        }
        for(int i=0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder(str);
            sb.append(arr[i]);
            if(sb.toString().length()<6)dfs(sb.toString());
        }
    }
}
