//https://school.programmers.co.kr/learn/courses/30/lessons/42579
import java.util.*;
class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String,Genre> map = new HashMap<>();
        
        for(int i =0; i<genres.length; i++){
            if(map.get(genres[i]) == null) map.put(genres[i], new Genre());
            map.get(genres[i]).addSong(new int[]{i,plays[i]});
        }

        PriorityQueue<Genre> pq = new PriorityQueue<>(Comparator.comparing((Genre g)->g.plays).reversed());
        
        for(Genre g : map.values()){
            pq.add(g);
        }
        List<Integer> answer = new LinkedList<>();
        
        while(!pq.isEmpty()){
            Genre genre = pq.poll();
            for(int i =0; i<2; i++){
                if(genre.q.isEmpty()) break;
                answer.add(genre.q.poll()[0]);
            }
        }
        
        return answer;
    }
    class Genre{
        int plays=0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing((int[] s) -> s[1]).reversed());
        
        void addSong(int[] song){
            this.plays+= song[1];
            q.add(song);
        }
    }
}
