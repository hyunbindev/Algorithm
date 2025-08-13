//https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.*;
class Solution {
    private int[] elements;
    private Set<Integer> resultSet = new HashSet<>();
    public int solution(int[] elements) {
        this.elements = elements;
        for(int i =0; i<elements.length; i++){
            getSum(i);
        }
        return resultSet.size();
    }
    public void getSum(int partition){
        for(int i = 0; i<this.elements.length; i++){
            int sum = 0;
            for(int p =0; p<partition; p++){
                sum += elements[(i+p)%this.elements.length];
            }
            this.resultSet.add(sum);
        }
    }
}
