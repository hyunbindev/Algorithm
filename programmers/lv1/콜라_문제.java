import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int a, int b, int n) {
        dfs(a,b,n);
        return answer;
    }
    void dfs(int a, int b, int n){
        if(n<a) return;
        int empty = n/a;
        //System.out.println(empty);
        answer+=empty*b;
        dfs(a,b,empty*b+(n%a));
    }
}
