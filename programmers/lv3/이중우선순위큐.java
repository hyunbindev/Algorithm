//https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
//이중 우선순위큐
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    private ArrayList<Integer> q = new ArrayList<>();
    public int[] solution(String[] operations) {
        for(String op : operations){
            operation(op);
        }
        int[] answer = {0,0};
        if(q.size() >0){
            answer[0] = q.get(q.size()-1);
            answer[1] = q.get(0);
        }
        return answer;
    }
    
    //명령
    private void operation(String op){
        if(op.charAt(0) == 'I'){
            int number = Integer.parseInt(op.substring(2));
            insert(number);
        }else{
            delete(op.substring(2));
        }
    }
    //삽입
    private void insert(int n){
        q.add(n);
        Collections.sort(q);
    }
    //삭제
    private void delete(String type){
        System.out.println(type);
        if(q.size()>0){
            if(type.equals("1")){
                q.remove(q.size()-1);
            }else{
                q.remove(0);
            }
            Collections.sort(q);
        }
    }
}
