import java.util.*;
class Solution {
    StringBuilder sq = new StringBuilder();
    StringBuilder sb = new StringBuilder("0");
    public int solution(String s) {
        
        for(char c : s.toCharArray()){
            convertNum();
            if(!Character.isLetter(c)){
                sb.append(String.valueOf(c));
                continue;
            }
            sq.append(c);
        }
        convertNum();
        return Integer.parseInt(sb.toString());
    }
    void convertNum(){
        String n = sq.toString();
        switch(n){
            case "zero":
                sb.append("0");
                sq.setLength(0);
                break;
            case "one":
                sb.append("1");
                sq.setLength(0);
                break;
            case "two":
                sb.append("2");
                sq.setLength(0);
                break;
            case "three":
                sb.append("3");
                sq.setLength(0);
                break;
            case "four":
                sb.append("4");
                sq.setLength(0);
                break;
            case "five":
                sb.append("5");
                sq.setLength(0);
                break;
            case "six":
                sb.append("6");
                sq.setLength(0);
                break;
            case "seven":
                sb.append("7");
                sq.setLength(0);
                break;
            case "eight":
                sb.append("8");
                sq.setLength(0);
                break;
            case "nine":
                sb.append("9");
                sq.setLength(0);
                break;
        }
        
    }
}
