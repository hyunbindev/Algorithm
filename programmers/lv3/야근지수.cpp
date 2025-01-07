https://school.programmers.co.kr/learn/courses/30/lessons/12927
//야근지수
#include <string>
#include <vector>
#include <queue>
using namespace std;

long long solution(int n, vector<int> works) {
    // 시도1. 우선순위 큐에 작업을 넣고 남은 시간이 없을때까지 하나씩 빼서 1를 뺌 n * works Log works
    long long answer = 0;
    priority_queue<int> q;
    for(int i=0; i<works.size(); i++){
        q.push(works[i]);
    }
    for(int i =0; i<n; i++){
        int work = q.top();
        if(work == 0) return 0;
        q.pop();
        work--;
        q.push(work);
    }
    while(!q.empty()){
        int work = q.top();
        answer += work*work;
        q.pop();
    }
    return answer;
}
