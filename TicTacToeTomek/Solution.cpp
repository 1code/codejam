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
        vector<string> board;
        for (int i = 0; i < 4; i++) {
            string row;
            cin >> row;
            board.push_back(row);
        }
        
        bool over = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == '.') {
                    over = false;
                    break;
                }
            }
        }

        bool oWin = win(board, 'O');
        bool xWin = win(board, 'X');

        if (oWin)
            return "O won";
        if (xWin)
            return "X won";
        if (over)
            return "Draw";
        return "Game has not completed";
    }

    bool win(vector<string> & board, char ch) {
        int c;
        for (int i = 0; i < 4; i++) {
            c = 0;
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == ch || board[i][j] == 'T')
                    c++;
                else
                    c = 0;
            }
            if (c == 4) return true;
        } 
        
        for (int j = 0; j < 4; j++) {
            c = 0;
            for (int i = 0; i < 4; i++) {
                if (board[i][j] == ch || board[i][j] == 'T')
                    c++;
                else
                    c = 0;
            }
            if (c == 4) return true;
        }
    
        c = 0;
        for (int i = 3; i >= 0; i--) {
            int j = 3-i;
            if (board[i][j] == ch || board[i][j] == 'T')
                    c++;
                else
                    c = 0;
        }
        if (c == 4) return true;

        c = 0;
        for (int i = 3; i >= 0; i--) {
            int j = i;
            if (board[i][j] == ch || board[i][j] == 'T')
                    c++;
                else
                    c = 0;
        }
        if (c == 4) return true;
        return false;
    }

    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}
