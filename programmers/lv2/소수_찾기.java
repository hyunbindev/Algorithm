//https://school.programmers.co.kr/learn/courses/30/lessons/42839
import java.util.*;
class Solution {
    int answer=0;
    Set<Integer> set = new HashSet<>();
    int[] nums;
    public int solution(String numbers) {
        nums = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            int n = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            nums[i]=n;
        }
        dfs("",new boolean[nums.length]);
        //System.out.println(set);
        return answer;
    }
    void isPrime(String str){
        int n = Integer.parseInt(str);
        if(n == 1) return;
        if(n == 0) return;
        for(int i=2; i<= (int)Math.sqrt(n); i++){
            if(n%i == 0) return;
        }
        if(set.contains(n)) return;
        set.add(n);
        answer++;
    }
    void dfs(String str, boolean[] visit){
        if(str != "")isPrime(str);
        for(int i=0; i<nums.length; i++){
            if(visit[i]) continue;
            boolean[] nv = visit.clone();
            nv[i]=true;
            StringBuilder sb = new StringBuilder(str);
            sb.append(nums[i]);
            dfs(sb.toString(),nv);
        }
    }
}
