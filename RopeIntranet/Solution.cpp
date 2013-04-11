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
        vector<int> a;
        vector<int> b;
        for (int i = 0; i < N; i++) {
            a.push_back(next<int>(input));
            b.push_back(next<int>(input));
        }
        int res = 0;
        for (int i = 1; i < N; i++)
            for (int j = i-1; j >= 0; j--)
                if ((a[i] > a[j] && b[i] < b[j]) || (a[i] < a[j] && b[i] > b[j]))
                   res++;
        return res;
    }

    ifstream input;
    ofstream output;
};


int main() {
    Solution sol;
    sol.solve();
}
