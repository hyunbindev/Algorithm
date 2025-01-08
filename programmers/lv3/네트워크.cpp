//https://school.programmers.co.kr/learn/courses/30/lessons/43162
//네트워크
#include <string>
#include <vector>
#include <iostream>
#include <set>
using namespace std;

void dfs(vector<int> &visit , vector<vector<int>> computers , int target ,int net){
    if(visit[target] != -1) return;
    visit[target] = net;
    for(int i=0; i<computers[target].size(); i++){
        if(visit[i] ==-1 && computers[target][i]){
            dfs(visit,computers,i,net);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    vector<int> visit(n,-1);
    for(int i =0; i<computers.size(); i++){
        dfs(visit,computers,i,i);
    }
    int answer = 0;
    set<vector<int>> uni(visit.begin() , visit.end());
    return uni.size();
}
