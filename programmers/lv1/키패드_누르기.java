import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        int[] left = {3,0};
        int[] right = {3,2};
        StringBuilder answer = new StringBuilder();
        for(int number : numbers){
            int[] tp = getPosition(number);
            if(number==1||number==4||number==7){answer.append('L');left=tp;continue;}
            if(number==3||number==6||number==9){answer.append('R');right=tp;continue;}

            int left_dist = Math.abs(left[0]-tp[0])+Math.abs(left[1]-tp[1]);
            int right_dist = Math.abs(right[0]-tp[0])+Math.abs(right[1]-tp[1]);
            
            if(left_dist<right_dist){
                answer.append('L');
                left=tp;
                continue;
            }
            if(right_dist<left_dist){
                answer.append('R');
                right = tp;
                continue;
            }
            if(hand.equals("right")){
                right=tp;
                answer.append('R');
            }else{
                left=tp;
                answer.append('L');
            }
        }
        return answer.toString();
    }
    int[] getPosition(int target){
        if(target==1) return new int[]{0,0};
        if(target==2) return new int[]{0,1};
        if(target==3) return new int[]{0,2};
        if(target==4) return new int[]{1,0};
        if(target==5) return new int[]{1,1};
        if(target==6) return new int[]{1,2};
        if(target==7) return new int[]{2,0};
        if(target==8) return new int[]{2,1};
        if(target==9) return new int[]{2,2};
        return new int[]{3,1};
    }
}
