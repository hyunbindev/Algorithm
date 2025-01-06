//https://school.programmers.co.kr/learn/courses/30/lessons/159993
//미로 탈출

#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

struct P{
    int y;
    int x;
};
int x[] = {1,0,-1,0};
int y[] = {0,1,0,-1};
int solution(vector<string> maps) {
    int answer = -1;
    vector<vector<int>> visit (100 , vector<int>(100,-1));
    queue<P> q;
    for(int i =0; i<maps.size(); i++){
        for(int j=0; j<maps[i].size(); j++){
            if(maps[i][j] == 'S'){
                P start{i,j};
                q.push(start);
                visit[i][j] = 0;
                break;
            }
        }
    }
    while(!q.empty()){
        P f = q.front();
        q.pop();
        if(maps[f.y][f.x] == 'L'){
            answer = visit[f.y][f.x];
            q = queue<P>();
            q.push(f);
            break;
        }
        for(int i =0; i<4; i++){
            P np = {f.y + y[i] , f.x + x[i]};
            if(0<=np.x && 0<=np.y && np.y < maps.size() && np.x < maps[0].size()){
                if(visit[np.y][np.x] == -1 || visit[np.y][np.x] > visit[f.y][f.x]+1){
                    if(maps[np.y][np.x] != 'X'){
                        q.push(np);
                        visit[np.y][np.x] = visit[f.y][f.x]+1;   
                    }
                }
            }
        }
    }
    
    if(answer == -1) return -1;
        for (auto& row : visit) {
        std::fill(row.begin(), row.end(), -1);
    }
    bool suc = false;
        while(!q.empty()){
        P f = q.front();
        q.pop();
        if(maps[f.y][f.x] == 'E'){
            answer += visit[f.y][f.x]+1;
            suc = true;
            break;
        }
        for(int i =0; i<4; i++){
            P np = {f.y + y[i] , f.x + x[i]};
            if(0<=np.x && 0<=np.y && np.y < maps.size() && np.x < maps[0].size()){
                if(visit[np.y][np.x] == -1 || visit[np.y][np.x] > visit[f.y][f.x]+1){
                    if(maps[np.y][np.x] != 'X'){
                        q.push(np);
                        visit[np.y][np.x] = visit[f.y][f.x]+1;   
                    }
                }
            }
        }
    }
    if(!suc) return -1;
    return answer;
}
