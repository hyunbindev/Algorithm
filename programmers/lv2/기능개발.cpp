//https://school.programmers.co.kr/learn/courses/30/lessons/42586
//기능 개발
#include <string>
#include <vector>
#include <iostream>
#include <stack>
using namespace std;

int day(int p , int s){
    int r = 100-p;
    if(r%s){
        return r/s +1;
    }
    return r/s;
}

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    stack<int> s;
    int d = 0;
    for(int i = progresses.size()-1; i>=0; i--){
        s.push(day(progresses[i],speeds[i]));
    }
    int c = 0;
    while(!s.empty()){
        if(d<s.top()){
            answer.push_back(c);
            c=0;
            d=s.top();
        }else{
            c++;
            s.pop();
        }
    }
    answer.push_back(c);
    answer.erase(answer.begin());
    return answer;
}
