//https://school.programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;
class Solution {
    char[][] b;
    Set<String> set = new HashSet<>();
    int answer = 0;
    public int solution(int m, int n, String[] board) {
        b = new char[m][n];
        for(int y = 0; y<m; y++){
            for(int x= 0; x<n; x++){
                b[y][x] = board[y].charAt(x);
            }
        }
        
        while(true){
            for(int y = 0; y<m-1; y++){
                for(int x = 0; x<n-1; x++){
                    char c = b[y][x];
                    if(c != '#' && c == b[y][x+1]){
                        String a = down(y+1,x,c);
                        String b = down(y+1,x+1,c);
                        if(a != null && b != null){
                            set.add(a);
                            set.add(b);
                            set.add(""+y+":"+x);
                            set.add(""+y+":"+(x+1));
                        }
                    }
                }
            }
            
            if(set.size() == 0) break;
            answer+=set.size();
            
            for(String s : set){
                String[] q = s.split(":");
                int y = Integer.parseInt(q[0]);
                int x = Integer.parseInt(q[1]);
                b[y][x] = '#';
            }
            
            set.clear();
            
            for(int x = 0; x<n; x++){
                for(int y = m-1; 0<=y; y--){
                    if(b[y][x] == '#'){
                        for(int k = y-1; 0<=k; k--){
                            if(b[k][x] != '#'){
                                b[y][x] = b[k][x];
                                b[k][x] = '#';
                                break;
                            }
                        }
                    }
                }
            }
            
            
            //for(int y=0; y<m; y++){
            //    for(int x= 0; x<n; x++){
            //        System.out.print(b[y][x]);
            //    }
            //    System.out.println();
            //}
            //System.out.println();
        }
        return answer;
    }
    
    String down(int y, int x, char c){
        if(b[y][x] == '#' && y+1<b.length){
            return down(y+1,x,c);
        }
        if(b[y][x] == c) return ""+y+":"+x;
        return null;
    }
}
