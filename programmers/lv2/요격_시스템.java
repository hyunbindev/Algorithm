//https://school.programmers.co.kr/learn/courses/30/lessons/181188
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int lastEnd = -1;
        
        for (int[] target : targets){
            if (lastEnd <= target[0]){
                count++;
                lastEnd = target[1];
            }
        }
        
        return count;
    }
}
