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
        output = freopen("data1.out" , "w" , stdout);
    }
    
    void solve() {
        int T;
        cin >> T;
        for(int i = 1; i <= T; i++)  {
            cout << "Case #" << i << ": " << solveCase1() << endl;
        }
    }

private:
    long long solveCase1() {
        int E, R, N;
        cin >> E >> R >> N;
        vector<int> v(N, 0);
        for (int i = 0; i < N; ++i) {
            cin >> v[i];
        }
    
        if (R > E) R = E;
        vector<int> u(N, 0);
        u[0] = E;
        for (int i = 1; i < N; ++i) {
            u[i] = R;
            for (int j = i-1; j >= 0; --j) {
                if (v[j] >= v[i]) break;
                if (u[i] + u[j] <= E) {
                    u[i] += u[j];
                    u[j] = 0;
                }
                else {
                    u[j] -= E-u[i];
                    u[i] = E;
                    break;
                }
            }
        }
        //for (int i = 0; i < N; ++i)
        //    cout << u[i] << " ";
        //cout << endl;
        long long res = 0;
        for (int i = 0; i < N; ++i)
            res += (long long)v[i]*u[i];
        return res;
    }
        
    long long solveCase2() {
        int E, R, N;
        cin >> E >> R >> N;
        vector<int> v(N, 0);
        for (int i = 0; i < N; ++i) {
            cin >> v[i];
        }
    
        if (R > E) R = E;
        vector<int> u(N, 0);
        stack<int> stk;
        stk.push(0);
        u[0] = E;
        for (int i = 1; i < N; ++i) {
            u[i] = R;
            while (!stk.empty() && v[stk.top()] < v[i]) {
                int j = stk.top();
                stk.pop();
                if (u[i] + u[j] <= E) {
                    u[i] += u[j];
                    u[j] = 0;
                }
                else {
                    u[j] -= E-u[i];
                    u[i] = E;
                    break;
                }
            }
            stk.push(i);
        }
        //for (int i = 0; i < N; ++i)
        //    cout << u[i] << " ";
        //cout << endl;
        long long res = 0;
        for (int i = 0; i < N; ++i)
            res += (long long)v[i]*u[i];
        return res;
    }

    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}
