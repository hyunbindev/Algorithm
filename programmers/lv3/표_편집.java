//https://school.programmers.co.kr/learn/courses/30/lessons/81303
import java.util.*;
class Solution {
    Stack<Node> stack = new Stack<>();
    Node[] table;
    int idx;
    public String solution(int n, int k, String[] cmd) {
        table = new Node[n];
        idx = k;
        table[0] = new Node(0);
        
        for(int i =1; i<n; i++){
            table[i] = new Node(i);
            table[i].pre = table[i-1];
            table[i-1].next = table[i];
        }
        
        for(int i = 0; i<cmd.length; i++){
            //System.out.println(idx);
            
            char c = cmd[i].charAt(0);
            //System.out.println(str);
            if(c=='D'){
                int cnt = Integer.parseInt(cmd[i].substring(2,cmd[i].length()));
                idx = moveDown(table[idx],cnt);
            }
            if(c=='U'){
                int cnt = Integer.parseInt(cmd[i].substring(2,cmd[i].length()));
                idx = moveUp(table[idx],cnt);
            }
            if(c=='C'){
                idx = delete(table[idx]);
            }
            if(c=='Z' && !stack.isEmpty()) rollBack();
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<table.length; i++){
            if(table[i].delete){
                sb.append("X");
            }else{
                sb.append("O");
            }
        }
        return sb.toString();
    }
    
    class Node{
        int idx;
        boolean delete = false;
        Node pre = null;
        Node next = null;
        Node(int idx){
            this.idx = idx;
        }
    }
    
    int moveUp(Node node, int cnt){
        while (cnt-- > 0) node = node.pre;
        return node.idx;
    }
    
    int moveDown(Node node, int cnt){
        while (cnt-- > 0) node = node.next;
        return node.idx;
    }
    
    int delete(Node node){
        node.delete = true;
        stack.add(node);
        
        if(node.pre != null){
            node.pre.next = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
            return node.next.idx;
        }
        return node.pre.idx;
    }
    
    void rollBack(){
        Node node = stack.pop();
        node.delete = false;
        if(node.next != null)node.next.pre = node;
        if(node.pre != null)node.pre.next = node;
    }
}
