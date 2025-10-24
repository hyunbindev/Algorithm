//https://school.programmers.co.kr/learn/courses/30/lessons/258709
import java.util.*;
class Solution {
    List<List<Integer>> combA = new ArrayList<>();
    List<List<Integer>> combB = new ArrayList<>();
    
    int diceNum;
    
    List<List<Integer>> sumA = new ArrayList<>();
    List<List<Integer>> sumB = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        
        diceNum = dice.length;
        
        getCombination(0, 0, new int[diceNum/2]);
        
        for(List<Integer> comb : combA){
            List<Integer> sumList = new ArrayList<>();
            getSum(0,comb,0,dice ,sumList);
            Collections.sort(sumList);
            sumA.add(sumList);
        }
        
        for(List<Integer> comb: combB){
            List<Integer> sumList = new ArrayList<>();
            getSum(0,comb,0,dice,sumList);
            Collections.sort(sumList);
            sumB.add(sumList);
        }
        long[] score = new long[combA.size()];
        for(int i=0; i<sumA.size(); i++){
            long wc = 0;
            List<Integer> sa = sumA.get(i);
            List<Integer> sb = sumB.get(i);
            for(int a :sa){
                wc += (long)lowerBound(sb,a);
            }
            score[i]=wc;
        }
        
        long result = Long.MIN_VALUE;
        int number = -1;
        for(int i=0; i<score.length; i++){
            if(result < score[i]){
                number=i;
                result=score[i];
            }
        }
        List<Integer> a =combA.get(number);
        
        int[] answer = new int[a.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i]= a.get(i)+1;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    void getCombination(int depth, int k, int[] comb){
        if(depth==comb.length){
            List<Integer> combList = new ArrayList<>();
            for(int n :comb)
                combList.add(n);
            combA.add(combList);
            boolean[] visit = new boolean[diceNum];
            for(int n:comb)
                visit[n]=true;
            List<Integer> combListB = new ArrayList<>();
            for(int i=0; i<visit.length; i++)
                if(!visit[i])combListB.add(i);
            combB.add(combListB);
            return;
        }
        for(int i=k; i<diceNum; i++){
            comb[depth]=i;
            getCombination(depth+1,i+1,comb);
        }
    }
    void getSum(int depth, List<Integer>comb, int sum,int[][] dice, List<Integer> sumList){
        if(depth==comb.size()){
            sumList.add(sum);
            return;
        }
        for(int i=0; i<6; i++){
            getSum(depth+1, comb, sum+dice[comb.get(depth)][i],dice,sumList);
        }
    }
    int lowerBound(List<Integer> list, int target){
        int l=0, r=list.size();
        while(l<r){
            int m=(l+r)/2;
            if(target<=list.get(m)){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
}
