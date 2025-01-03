//https://school.programmers.co.kr/learn/courses/30/lessons/12980
//점프와 순간 이동
#include <iostream>
using namespace std;

int recurFunc(int target){
    if(target == 0) return 0;
    int result = recurFunc(target/2);
    if(target % 2){
        result++;
    }
    return result;
}

int solution(int n)
{
    //초기단계 0에서 1까지는 무조건 배터리를 사용해야함->시도3에 의해 필요없어짐
    //시도 1 최대한 이동할 수 있을만큼 점프하여 이동 ->실패 최적의 결과값이 아님
    //시도 2 목표가 2로 안나누어 떨어지는 수를 구하면됨 ->실패
    //시도 3 목표가격에서 2로 나누고 나머지가 존재할경우만 배터리를 이용해 이동하면됨 
    return recurFunc(n);
}
