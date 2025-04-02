//https://school.programmers.co.kr/learn/courses/30/lessons/12979

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for(int station : stations){
            int startRange = station - w;
            if(startRange > start){
                int r = startRange - start;
                answer += r/(2*w +1);
                if(r%(2*w + 1) != 0) answer++;
            }
            start = station + w + 1;
        }
        if(start <= n){
            int r = n-start+1;
            answer += r/(2*w+1);
            if(r%(2*w+1) != 0) answer++;
        }
        return answer;
    }
}
