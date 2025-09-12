//https://school.programmers.co.kr/learn/courses/30/lessons/17686


import java.util.*;
class Solution {
    public List<String> solution(String[] files) {
        List<String> answer = new ArrayList<>();
        
        PriorityQueue<File> pq = new PriorityQueue<>((a,b)->{
            if(a.header.equals(b.header)) return a.number-b.number; 
            return a.header.compareTo(b.header);
        });
        
        for(String file : files){
            pq.add(new File(file));
        }
        
        File[] fs = new File[files.length];
        
        for(int i = 0; i<fs.length; i++){
            fs[i] = new File(files[i]);
        }
        
        
        Arrays.sort(fs, (a,b)->{
            if(a.header.equals(b.header)) return a.number-b.number; 
            return a.header.compareTo(b.header);
        });
        
        for(int i =0; i<fs.length; i++){
            answer.add(fs[i].original);
        }
        
        
        return answer;
    }
    class File{
        String original;
        String header;
        int number;
        File(String file){
            this.original = file;
            char[] arr = file.toUpperCase().toCharArray();
            
            String type = "HEADER";
            
            String temp = "";
            
            for(int i =0; i<arr.length; i++){
                if(type.equals("HEADER")){
                    temp+=arr[i];
                    if(Character.isDigit(arr[i+1])){
                        type ="NUMBER";
                        this.header = temp;
                        temp = "";
                        continue;
                    };
                }
                if(type.equals("NUMBER")){
                    temp+=arr[i];
                    if(arr.length<=i+1 || !Character.isDigit(arr[i+1])){
                        type = "TAIL";
                        this.number = Integer.parseInt(temp);
                        temp = "";
                        continue;
                    }
                }
            }
        }
    }
}
