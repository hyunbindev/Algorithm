//https://school.programmers.co.kr/learn/courses/30/lessons/42577
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String num : phone_book){
            set.add(num);
        }
        for(String num : phone_book){
            for(int i =0; i<num.length(); i++){
                String sub = num.substring(0,i);
                if(set.contains(sub)) return false;
            }
        }
        return true;
    }
}
