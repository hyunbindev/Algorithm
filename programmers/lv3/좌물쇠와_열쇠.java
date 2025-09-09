//https://github.com/hyunbindev/Algorithm/new/master/programmers/lv3
import java.util.*;
class Solution {
    //한칸씩 이동시키고
    //회전하면됨
    int[][][] keys;
    public boolean solution(int[][] key, int[][] lock) {
        keys = new int[4][key.length][key.length];
        
        boolean answer = false;
        
        keys[0] = key;
        
        for(int i=1; i<keys.length; i++){
            keys[i] = rotate(keys[i-1]);
        }
        
        int[][] paddingLock = new int[lock.length+2*key.length-2][lock.length+2*key.length-2];
        
        for(int y=0; y<lock.length; y++){
            for(int x=0; x<lock.length; x++){
                paddingLock[key.length-1+y][key.length-1+x] = lock[y][x];
            }
        }
        
        
        for(int i = 0; i<=paddingLock.length-key.length; i++){
            for(int j = 0; j<=paddingLock.length-key.length; j++){
                //검사할 키판
                for(int k =0; k<keys.length; k++){
                    
                    int[][] temp = new int[paddingLock.length][paddingLock.length];
                    for(int y = 0; y< temp.length; y++){
                        temp[y] = paddingLock[y].clone();
                    }
                    for(int ky = 0; ky<key.length; ky++){
                        for(int kx = 0; kx<key.length; kx++){
                            temp[ky+i][kx+j] += keys[k][ky][kx];
                        }
                    }
                    //좌물쇠 검사
                    boolean pass = true;
                    for(int ly = key.length-1; ly<key.length+lock.length-1; ly++){
                        for(int lx = key.length-1; lx<key.length+lock.length-1; lx++){
                            if(temp[ly][lx] != 1){
                                pass = false;
                                break;
                            }
                        }
                        if(!pass) break;
                    }
                    if(pass) return true;
                }
            }
        }
        
        return answer;
    }
    
    int[][] rotate(int[][] key){
        int[][] newKey = new int[key.length][key.length];
        for(int y = 0; y<key.length; y++){
            for(int x = 0; x<key[y].length; x++){
                newKey[x][(key.length-1)-y] = key[y][x];
            }
        }
        return newKey;
    }
}
