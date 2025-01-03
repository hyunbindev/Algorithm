//https://school.programmers.co.kr/learn/courses/30/lessons/12909
//올바른 괄호

#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    //시도 1. '('의 수와 ')'의 수가 같으면 된다.
    //시도 2. 숫자가 같고 먼저 '('로 열려있어야된다. (카운트를 저장 진행중 0이하시 false 리턴
    int count = 0;
    for(char c : s){
        if(c == '('){
            count++;
        }else{
            if(count<1){
                return false;
            }
            count--;
        }
    }
    return count == 0;
}
