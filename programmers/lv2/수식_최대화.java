//https://school.programmers.co.kr/learn/courses/30/lessons/67257
import java.util.*;
class Solution {
    List<char[]> permutes = new ArrayList<>();
    char[] operator = {'+','-','*'};
    public long solution(String expression) {
        long answer = 0;
        getPermute(0,new char[3],new boolean[3]);
        for(char[] op : permutes){
            answer = Math.max(Math.abs(calc(expression, op)),answer);
        }
        return answer;
    }
    void getPermute(int depth, char[]permute, boolean[] visit){
        if(visit.length <= depth){
            this.permutes.add(permute.clone());
            return;
        }
        for(int i=0; i<operator.length; i++){
            if(visit[i])continue;
            permute[depth]=operator[i];
            visit[i]=true;
            getPermute(depth+1, permute, visit);
            visit[i]=false;
        }
    }
    long calc(String str, char[] permute){
        List<Long>number = new ArrayList<>();
        List<Character>ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*'){
                number.add(Long.parseLong(String.valueOf(sb.toString())));
                sb.setLength(0);
                ops.add(str.charAt(i));
            }else{
                sb.append(str.charAt(i));
            }
        }
        number.add(Long.parseLong(String.valueOf(sb.toString())));
        for(char op : permute){
            for(int i=0; i<ops.size();){
                if(op==ops.get(i)){
                    long res = excute(number.remove(i),number.remove(i),ops.remove(i));
                    number.add(i,res);
                }else{
                    i++;
                }
            }
        }
        return number.get(0);
    }
    long excute(long a, long b, char op){
        if(op == '*') return a*b;
        if(op == '+') return a+b;
        return a-b;
    }
}
