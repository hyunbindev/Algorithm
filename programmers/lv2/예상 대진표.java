//https://school.programmers.co.kr/learn/courses/30/lessons/12985#
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(a != b){
            a = (a+1)/2;
            b = (b+1)/2;
            if(a==b) break;
            answer++;
        }
        return answer;
    }
}
