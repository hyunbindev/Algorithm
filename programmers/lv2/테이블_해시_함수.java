//https://school.programmers.co.kr/learn/courses/30/lessons/147354
import java.util.*;
class Solution {
    List<String> bits = new ArrayList<>();
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data,(a,b)->{
            if(a[col-1]==b[col-1]) return b[0]-a[0];
            return a[col-1]-b[col-1];
        });
        for(int i=row_begin-1; i<row_end; i++){
            int[] row = data[i];
            int s =0;
            for(int r=0; r<row.length; r++){
                s+=(row[r]%(i+1));
            }
            bits.add(Integer.toBinaryString(s));
        }
        return Integer.parseInt(xor(),2);
    }
    String xor(){
        StringBuilder sb1 = new StringBuilder(bits.get(0));
        for(int i=1; i<bits.size(); i++){
            StringBuilder sb2 = new StringBuilder(bits.get(i));
            sb1 = cal(sb1,sb2);
        }
        return sb1.toString();
    }
    StringBuilder cal(StringBuilder a, StringBuilder b){
        StringBuilder ta = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        int maxLen = Math.max(a.length(), b.length());
        for(int i=0; i<maxLen-a.length(); i++)
            ta.append('0');
        ta.append(a);
        
        for(int i=0; i<maxLen-b.length(); i++)
            tb.append('0');
        tb.append(b);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<maxLen; i++){
            if(ta.charAt(i)!=tb.charAt(i)){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
        return sb;
    }
}
