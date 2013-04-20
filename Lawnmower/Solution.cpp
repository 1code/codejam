#include <vector>
#include <list>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <fstream>

using namespace std;

class Solution {
public:
    Solution() {
        input = freopen("data.in" , "r" , stdin);
        output = freopen("data.out" , "w" , stdout);
    }

    void solve() {
        int T;
        cin >> T;
        for(int i = 1; i <= T; i++)  {
            cout << "Case #" << i << ": " << solveCase() << endl;
        }
    }

private:
    string solveCase() {
        int N, M;
        cin >> N >> M;
        vector<vector<int> > board;
        for (int i = 0; i < N; i++) {
            vector<int> row;
            for (int j = 0; j < M; j++) {
                int num;
                cin >> num;
                //cout << num << " ";
                row.push_back(num);
            }
            //cout << endl;
            board.push_back(row);
        }
       
        if (N == 1 || M == 1) return "YES";
        
        vector<int> rows(N, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > rows[i]) rows[i] = board[i][j];
            }
        }
        vector<int> cols(M, 0);
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (board[i][j] > cols[j]) cols[j] = board[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] < rows[i] && board[i][j] < cols[j])
                    return "NO";
            }
        }
        return "YES";
    }

    bool check(vector<vector<int> > board, int x, int y) {
        int N = board.size();
        int M = board[0].size();
        int i, j;
        i = x, j = 0;;
        for (; j < M; j++) {
            if (board[i][j] > board[x][y]) {
                break;
            }
        }
        if (j == M) return true;
        
        i = 0, j = y;
        for (; i < N; i++) {
            if (board[i][j] > board[x][y]) {
                break;
            }
        }
        if (i == N) return true;

        return false;
    }

    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}
