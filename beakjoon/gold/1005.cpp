//https://www.acmicpc.net/problem/1005
//ACM Craft
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main() {
	vector<int>result;
	int a; cin >> a;
	for (int t = 0; t < a; t++) {
		int n, k;
		cin >> n >> k;
		vector<int>w(n + 1);
		vector<int>dp(n + 1);
		for (int i = 1; i <= n; i++) {
			cin >> w[i];
		}
		vector<int>start(n + 1);
		vector<vector<int>>graph(n + 1);
		for (int i = 0; i < k; i++) {
			int u, v;
			cin >> u >> v;
			graph[u].push_back(v);
			start[v]++;
		}
		int win;
		cin >> win;
		queue<int>q;
		for (int i = 1; i < start.size(); i++) {
			if (start[i] == 0) {
				q.push(i);
				dp[i] = w[i];
			}
		}
		while (!q.empty()) {
			int Q = q.front();
			q.pop();
			for (int i = 0; i < graph[Q].size(); i++) {
				if (dp[graph[Q][i]] < dp[Q] + w[graph[Q][i]]) {
					dp[graph[Q][i]] = dp[Q] + w[graph[Q][i]];
					q.push(graph[Q][i]);
				}
			}
		}
		result.push_back(dp[win]);
	}
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << "\n";
	}
	return 0;
}
