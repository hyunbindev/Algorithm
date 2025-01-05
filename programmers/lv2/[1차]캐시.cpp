//https://school.programmers.co.kr/learn/courses/30/lessons/17680
//[1차] 캐시

#include <string>
#include <vector>
#include <iostream>
using namespace std;

string toLowCase(string s){
    string temp = "";
    for(char c : s){
        if(c<97){
            temp.push_back(c+32);
        }else{
            temp.push_back(c);
        }
    }
    return temp;
}

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    vector<string>c(cacheSize,"");
    if(!cacheSize) return cities.size() * 5;
    for(string city: cities){
        bool hit = false;
        for(int i =0; i<cacheSize; i++){
            if(c[i] == toLowCase(city)){
                hit = true;
                string temp = toLowCase(city);
                c.erase(c.begin() + i);
                c.insert(c.begin(),toLowCase(city));
                break;
            }
        }
        if(hit){
            answer++;
        }else{
            answer +=5;
            c.pop_back();
            c.insert(c.begin(),toLowCase(city));
        }
    }
    return answer;
}
