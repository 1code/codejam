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

template< typename T>
T next(istream & is) {
    T t;
    is >> t;
    return t;
}

template< typename T>
void print(ostream & os, int i, T t) {
    os << "Case #" << i << ": " << t << endl;  
}

class Solution {
public:
    Solution() {
        input.open("data.in", ios::in);
        output.open("data.out", ios::out);
    }

    ~Solution() {
        input.close();
        output.close();
    }

    void solve() {
        int T = next<int>(input);
        for (int i = 1; i <= T; i++) {
            print(output, i, solveCase());
            //print(cout, i, solveCase());
        } 
    }

private:
    int solveCase() {
        int N = next<int>(input);
        vector<int> num;
        num.reserve(N);
        for (int i = 0; i < N; i++)
            num.push_back(next<int>(input));
        vector<int> dp(N, 1);
        for (int i = 1; i < N; i++)
            for (int j = 0; j < i; j++)
                if (num[i] > num[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
        int res = 0;
        for (int i = 0; i < N; i++)
            if (dp[i] > res)
                res = dp[i];
        res = N-res;
        return res;
    }

    ifstream input;
    ofstream output;
};


int main() {
    Solution sol;
    sol.solve();
}
