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

    ~Solution() {
        fclose(input);
        fclose(output);
    }

    void solve() {
        int T;
        cin >> T;
        for(int i = 1; i <= T; i++)  {
            cout << "Case #" << i << ": " << solveCase() << endl;
        }
    }

private:
    long long solveCase() {
        long long r, t;
        cin >> r >> t;
        //cout << r << "," << t << endl;
        long long l = 0, u = t, m;
        while (l+1 < u) {
            m = l + (u-l)/2;
            if (check(r, m, t))
                l = m;
            else
                u = m;
            //cout << l << "," << u << endl;
        }
        return l;
    }

    bool check(long long r, long long n, long long t) {
        long long s = 2*r+2*n-1;
        if (s > 2e18 || 2e18 / s < n) return false;
        return s*n <= t;
    }

    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}
