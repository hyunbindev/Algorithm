//https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=cpp
//정수 삼각형
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    //시도 1. Top to Bottom
    //시도 2. Bottom to Top
    vector<vector<int>> sum = triangle;
    for(int h=sum.size()-2; h>=0; h--){
        for(int w=0; w<sum[h].size(); w++){
            int left = sum[h+1][w];
            int right = sum[h+1][w+1];
            if(left>right){
                sum[h][w] = sum[h][w]+left;
            }else{
                sum[h][w] = sum[h][w]+right;
            }
        }
    }
    return sum[0][0];
}
