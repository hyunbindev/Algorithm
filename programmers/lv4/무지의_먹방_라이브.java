//https://school.programmers.co.kr/learn/courses/30/lessons/42891
import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        int[][] foods = new int[food_times.length][2];
        for(int i=0; i<foods.length; i++){
            foods[i][0]=food_times[i];
            foods[i][1]=i+1;
        }
        Arrays.sort(foods,(a,b)->a[0]-b[0]);
        long eat = 0;
        long time = 0;
        for(int i=0; i<foods.length; i++){
            long diff = (foods[i][0]-eat)*(foods.length-i);
            //System.out.println(time);
            if(k<time+diff){
                List<int[]> left = new ArrayList<>();
                for(int j=i; j<foods.length; j++)left.add(foods[j]);
                left.sort((a, b) -> a[1] - b[1]);
                long idx = (k-time)%left.size();
                return left.get((int)idx)[1];
            }
            time+=diff;
            eat=foods[i][0];
        }
        
        return -1;
    }
}
//1 2 3
//3 
