//https://school.programmers.co.kr/learn/courses/30/lessons/68646
import java.util.*;
class Solution {
    //최대로 작은 수 반으로 나누고
    //왼쪽에서부터
    //오른쪽에서부터
    //다음 수가 나보다 더 작아야 살아남음
    public int solution(int[] a) {
        int answer = 1;
        if(a.length == 1) return 1;
        if(a.length == 2) return 2;
        PriorityQueue<풍선> pq = new PriorityQueue<>(Comparator.comparing((b -> b.num)));
        for(int i = 0; i<a.length; i++){
            pq.add(new 풍선(i,a[i]));
        }
        
        풍선 너무큰풍선 = pq.poll();
        
        
        int 왼쪽기준 = 0;
        if(왼쪽기준 != 너무큰풍선.idx) answer++;
        for(int i=1; i<너무큰풍선.idx; i++){
            if(a[i] < a[왼쪽기준]){
                왼쪽기준 = i;
                answer++;
            }
        }
        int 오른쪽기준 = a.length-1;
        if(오른쪽기준 != 너무큰풍선.idx) answer++;
        for(int i=a.length-2; 너무큰풍선.idx<i; i--){
            if(a[i] < a[오른쪽기준]){
                오른쪽기준 = i;
                answer++;
            }
        }
        return answer;
    }
    class 풍선{
        int idx;
        int num;
        풍선(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}
