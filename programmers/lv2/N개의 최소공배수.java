//https://school.programmers.co.kr/learn/courses/30/lessons/12953
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int idx = 1; idx<arr.length; idx++){
            int a = answer;
            int b = arr[idx];
            while(answer != arr[idx]){
                if(answer<arr[idx]){
                    answer+=a;
                }
                if(answer>arr[idx]){
                    arr[idx]+=b;
                }
            }
        }
        return answer;
    }
}
