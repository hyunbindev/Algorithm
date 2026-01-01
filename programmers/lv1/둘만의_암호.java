import java.util.*;
class Solution {
    List<Character> charIndex = new ArrayList<>();
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=(int)'a'; i<=(int)'z'; i++){
            charIndex.add((char)i);
        }
        for(char c : skip.toCharArray()){
            for(int i = 0; i<charIndex.size(); i++){
                if(charIndex.get(i)==c){
                    charIndex.remove(i);
                    break;
                }
            }
        }
        
        for(char c: s.toCharArray()){
            for(int i=0; i<charIndex.size(); i++){
                if(charIndex.get(i)==c){
                    sb.append(charIndex.get((i+index)%charIndex.size()));
                }
            }
        }
        
        return sb.toString();
    }
}
