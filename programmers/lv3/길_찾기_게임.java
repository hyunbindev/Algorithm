//https://school.programmers.co.kr/learn/courses/30/lessons/42892
import java.util.*;
//이진트리 구조로 어떻게 만들까
class Solution {
    List<Integer> prl = new ArrayList<>();
    List<Integer> pol = new ArrayList<>();
    public List<List<Integer>> solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }
        Arrays.sort(nodes, (a,b)->{
            if(a.y==b.y) return a.x-b.x;
            return b.y-a.y;
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i<nodeinfo.length; i++){
            Node child = nodes[i];
            root.insert(child);
        }
        preOrder(root);
        postOrder(root);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(prl);
        answer.add(pol);
        return answer;
    }
    void preOrder(Node parent){
        prl.add(parent.idx);
        if(parent.left != null) preOrder(parent.left);
        if(parent.right != null) preOrder(parent.right);
    }
    
    void postOrder(Node parent){
        if(parent.left != null) postOrder(parent.left);
        if(parent.right != null) postOrder(parent.right);
        pol.add(parent.idx);
    }
    class Node{
        int x;
        int y;
        int idx;
        Node left = null;
        Node right = null;
        
        Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        void insert(Node child){
            if(child.x<this.x){
                if(this.left == null){
                    this.left = child;
                    return;
                };
                this.left.insert(child);
            }
            if(this.x<child.x){
                if(this.right == null){
                    this.right = child;
                    return;
                };
                this.right.insert(child);
            }
        }
    }
}
