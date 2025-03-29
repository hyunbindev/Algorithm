class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int depth = triangle.length-1;
        
        for(int d = depth; d>0; d--){
            for(int n = 0; n<triangle[d].length-1; n++){
                int pn = triangle[d-1][n];
                triangle[d-1][n] = Math.max(triangle[d][n]+pn,triangle[d][n+1]+pn);
            }
        }
        return triangle[0][0];
    }
}
