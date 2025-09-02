//https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;
/*
* 0u
* 1d
* 2r
* 3l
**/
class Solution {
    int answer = 0;
    public int solution(String dirs) {
        boolean[][][]visit = new boolean[11][11][4];
        int y = 5;
        int x = 5;
        for(char d :dirs.toCharArray()){
            switch(d){
                case 'U':
                    if(0<=y-1){
                        if(!visit[y-1][x][0]){
                            visit[y-1][x][0] = true;
                            visit[y][x][1]=true;
                            answer++;
                        }
                        y--;
                    }
                    break;
                case 'D':
                    if(y+1<11){
                        if(!visit[y+1][x][1]){
                            visit[y+1][x][1] = true;
                            visit[y][x][0] = true;
                            answer++;
                        }
                        y++;
                    }
                    break;
                case 'R':
                    if(x+1<11){
                        if(!visit[y][x+1][2]){
                            visit[y][x+1][2] = true;
                            visit[y][x][3] = true;
                            answer++;
                        }
                        x++;
                    }
                    break;
                case 'L':
                    if(0<=x-1){
                        if(!visit[y][x-1][3]){
                            visit[y][x-1][3] = true;
                            visit[y][x][2] = true;
                            answer++;
                        }
                        x--;
                    }
                    break;
            }
        }
        return this.answer;
    }
}
