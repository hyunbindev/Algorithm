//https://school.programmers.co.kr/learn/courses/30/lessons/172927#
import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        PriorityQueue<Partition> pq = new PriorityQueue<>((a,b)->b.cost - a.cost);
        PriorityQueue<Integer> pqp = new PriorityQueue<>((a,b)->b - a);
        
        Partition partition = new Partition();
        
        int picksCount = 0;
        for(int p : picks){
            picksCount += p;
        }
        picksCount*=5;
        
        for(int i = 1; i<=Math.min(minerals.length,picksCount); i++){
            partition.add(minerals[i-1]);
            if(i%5 == 0){
                pq.add(partition);
                partition = new Partition();
            }
        }
        
        if(partition.cost != 0)pq.add(partition);
        
        for(int i =0; i<picks[0]; i++){
            pqp.add(25);
        }
        for(int i = 0; i<picks[1]; i++){
            pqp.add(5);
        }
        for(int i = 0; i<picks[2]; i++){
            pqp.add(1);
        }
        
        while(!pq.isEmpty() && !pqp.isEmpty()){
            Partition pt = pq.poll();
            int pick = pqp.poll();
            //System.out.println(pt.getCostByPick(pick));
            answer+= pt.getCostByPick(pick);
        }
        
        return answer;
    }
    
    int getCost(String mineral){
        switch(mineral){
            case "diamond":
                return 25;
            case "iron":
                return 5;
            case "stone":
                return 1;
        }
        return 1;
    }
    
    class Partition{
        int cost=0;
        List<Integer> minerals = new ArrayList<>();
        void add(String mineral){
            minerals.add(getCost(mineral));
            cost += getCost(mineral);
        }
        int getCostByPick(int pick){
            int cost = 0;
            for(int mineral : minerals){
                cost += mineral/pick == 0 ? 1 : mineral/pick;
            }
            return cost;
        }
    }
}
