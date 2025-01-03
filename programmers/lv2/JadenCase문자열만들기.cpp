//https://school.programmers.co.kr/learn/courses/30/lessons/12951
//JadenCase 문자열 만들기
#include <string>
#include <vector>
#include <iostream>
using namespace std;

char toUpper(char c){
    if(97<=c && c<=122){
        return c-32;
    }
    return c;
}
char toLower(char c){
    if(65<=c && c<=90){
        return c+32;
    }
    return c;
}


string solution(string s) {
    string answer = "";
    //시도1. 공백문자후 다음 문자는 대문자로 바꾼다.
    //a=97 ,z=122 A=65 , Z = 90 즉 소문자에서 32를 뺀다면 대문자로 바뀐다. ' '=32 ,'1'=49 , '9' = 57
    bool change = true;
    for(int i =0; i <s.size(); i++){
        if(s[i] == ' '){
            change = true;
            answer.push_back(' ');
        }else{
            if(change){
                answer.push_back(toUpper(s[i]));
                change = false;
            }else{
                answer.push_back(toLower(s[i]));
            }
        }
    }
    return answer;
}
