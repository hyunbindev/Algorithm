//https://school.programmers.co.kr/learn/courses/30/lessons/60061
import java.util.*;
class Solution {
    boolean[][] fill;
    boolean[][] flat;
    public List<int[]> solution(int n, int[][] build_frame) {
        fill = new boolean[n+1][n+1];
        flat = new boolean[n+1][n+1];
        List<int[]> answer = new ArrayList<>();
        
        for(int[] build : build_frame){
            int x=build[0],y=build[1],a=build[2],b=build[3];
            if(a==0){
                if(b==0) fill[y][x]=false;
                if(b==1) fill[y][x]=true;
                if(!valid()){
                    if(b==0) fill[y][x]=true;
                    if(b==1) fill[y][x]=false;
                }
            }
            if(a==1){
                if(b==0) flat[y][x]=false;
                if(b==1) flat[y][x]=true;
                if(!valid()){
                    if(b==0) flat[y][x]=true;
                    if(b==1) flat[y][x]=false;
                }
            }
        }
        for(int y=0; y<fill.length; y++){
            for(int x=0; x<fill[y].length; x++){   
                if(fill[y][x]) answer.add(new int[]{x,y,0});
                if(flat[y][x]) answer.add(new int[]{x,y,1});
            }
        }
        Collections.sort(answer,(a,b)->{
            if(a[0]==b[0] && a[1]==b[1]) return a[2]-b[2];
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        return answer;
    }
    boolean valid(){
        for(int y=0; y<fill.length; y++){
            for(int x=0; x<fill[y].length; x++){
                if(!(validFill(x,y) && validFlat(x,y))) return false;
            }
        }
        return true;
    }
    
    boolean validFill(int x, int y){
        if(!fill[y][x]) return true;
        if(y==0) return true;
        if(fill[y-1][x]) return true;
        if(flat[y][x]) return true;
        if(0<=x-1 && flat[y][x-1]) return true;
        return false;
    }
    boolean validFlat(int x, int y){
        if(!flat[y][x]) return true;
        if(y==0) return false;
        if(fill[y-1][x]) return true;
        if(x+1<fill[y].length && fill[y-1][x+1]) return true;
        if(0<=x-1 && x+1<flat[y].length){
            if(flat[y][x-1] && flat[y][x+1]) return true;
        }
        return false;
    }
}
