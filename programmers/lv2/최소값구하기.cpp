//https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=cpp
//최소값 구하기
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    //시도1. 직관적 접근 두배열에서 최대수와 최소 수를 곱해 누적합을 구한다면 최소의 누적합을 도출해낼 것이다.
    //구현 두 벡터를 정렬 이후 곱하여 누적합 도출
    vector<int> arr1 = A;
    vector<int> arr2 = B;
    sort(arr1.begin(),arr1.end(),greater<int>());
    sort(arr2.begin(),arr2.end(),less<int>());
    for(int i=0; i<A.size(); i++){
        answer += arr1[i] * arr2[i];
    }
    return answer;
}
