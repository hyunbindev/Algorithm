//https://school.programmers.co.kr/learn/courses/30/lessons/12939
//최대값과 최소값
#include <string>
#include <vector>

using namespace std;

int pow(int base, int times) {
	if (times == 0) return 1;
	int result = 1;
	for (int i = 0; i < times; i++) {
		result *= base;
	}
	return result;
}

int convertInteger(string s) {
	int integer = 0;
	if (s[0] == '-') {
		for (int p = s.size() - 1; p > 0; p--) {
			integer += (s[p] - 48) * pow(10, (s.size() - 1) - p);
		}
		return -integer;
	}
	else {
		for (int p = s.size() - 1; p >= 0; p--) {
			integer += (s[p] - 48) * pow(10, (s.size() - 1) - p);
		}
		return integer;
	}
}

string solution(string s) {
    string answer = "";
    
    int min = 2147483647;
    int max = -2147483647;
    
    string temp ="";
    
    for(int i =0; i<s.size(); i++){
        if(s[i] == ' '){
            int target = convertInteger(temp);
            if(target < min){
                min = target;
            }
            if(target > max){
                max = target;
            }
            temp="";
        }else{
            temp.push_back(s[i]);
        }
    }
    int target = convertInteger(temp);
    if(target>max){
        max = target;
    }
    if(target<min){
        min = target;
    }
    answer+=(to_string(min));
    answer.push_back(' ');
    answer+=(to_string(max));
    return answer;
}
