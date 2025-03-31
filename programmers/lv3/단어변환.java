//https://github.com/hyunbindev/Algorithm/new/master/programmers/lv3

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        dfs(0,0,begin,target,words,visit);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void dfs(int index,
                    int count, 
                    String begin, 
                    String target,
                    String[] words,
                    boolean[] visit)
    {
        if(begin.equals(target)){
            System.out.println(count);
            this.answer = count;
        }
        for(int i =0; i< words.length; i++){
            if(visit[i] || !checkWord(begin,words[i]) || answer <= count) continue;
            visit[i] = true;
            dfs(i,count+1,words[i],target,words,visit);
            visit[i] = false;
        }
    }
    
    private boolean checkWord(String word, String target){
        int cnt = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != target.charAt(i)) cnt++;
            if(cnt>1) return false;
        }
        return true;
    }
}
