//https://school.programmers.co.kr/learn/courses/30/lessons/49993
//스킬트리

#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    //1시도. skill 문자열만 필터링 해서 순서를 비교하기
    int answer = 0;
    for(string tree :skill_trees){
        string temp = "";
        for(int i =0; i<tree.size(); i++){
            for(int k=0; k<skill.size(); k++){
                if(tree[i] == skill[k]){
                    temp.push_back(tree[i]);
                }
            }
        }
        bool isMatch = true;
        for(int i=0; i<temp.size(); i++){
            if(temp[i] != skill[i]){
                isMatch = false;
                break;
            }
        }
        if(isMatch) answer ++;
    }
    return answer;
}
