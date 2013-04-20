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
            cout << "Case #" << i << ": " << solveCase(i) << endl;
        }
    }

private:
    string solveCase(int id) {
        int N, K;
        cin >> N >> K;
        vector<string> board;
        board.reserve(N);
        for (int i = 0; i < N; i++){
            string row;
            cin >> row;
            board.push_back(row);
        }

        rotate(board);

        drop(board);

        bool red = check(board, 'R', K, id);
        bool blue = check(board, 'B', K, id);

        if (red && blue)
            return "Both";
        if (red)
            return "Red";
        if (blue)
            return "Blue";
        return "Neither";
    }

    void rotate(vector<string> & board) {
        int N = board.size();
        for (int j = 0; j < N/2; j++) {
            int first = j;
            int last = N - j - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = board[first][i];
                board[first][i] = board[last-offset][first];
                board[last-offset][first] = board[last][last-offset];
                board[last][last-offset] = board[i][last];
                board[i][last] = top;
            }
        }
    }

    void drop(vector<string> & board) {
        int N = board.size();
        for (int j = 0; j < N; j++){
            int i1 = N-1;
            while (true) {
                while (i1 >= 0 && board[i1][j] != '.') i1--;
                if (i1 < 0) break;
                int i2 = i1-1;
                while (i2 >= 0 && board[i2][j] == '.') i2--;
                if (i2 < 0) break;
                board[i1][j] = board[i2][j];
                board[i2][j] = '.';
            }
        }
    }

    bool check(vector<string> & board, char ch, int K, int caseID) {
        int N = board.size();

        for (int i = N-1; i >= 0; --i) {
            int c = 0;
            for (int j = 0; j <= N-1; ++j) {
                if (board[i][j] == ch) {
                    if(++c == K) return true;
                }
                else c = 0;
            }
        }

        for (int j = 0; j <= N-1; ++j) {
            int c = 0;
            for (int i = N-1; i >= 0; --i) {
                if (board[i][j] == ch) {
                    if(++c == K) return true;
                }
                else c = 0;
            }
        }

        for (int i = 0; i < N*2-1; ++i) {
            int k = i < N ? 0 : i-N+1;
            int c = 0;
            for (int j = k; j <= i-k; ++j) {
                int row = j;
                int col = (N-1)-(i-j);
                if (board[row][col] == ch) {
                    if(++c == K) return true;
                }
                else c = 0;
            }
        }

        for (int i = 0; i < N*2-1; ++i) {
            int k = i < N ? 0 : i-N+1;
            int c = 0;
            for (int j = k; j <= i-k; ++j) {
                int row = j;
                int col = (i-j);
                if (board[row][col] == ch) {
                    if(++c == K) return true;
                }
                else c = 0;
            }
        }

        return false;
    }

    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}