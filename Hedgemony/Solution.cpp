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
        output << fixed << setprecision(6);
        //cout << fixed << setprecision(6);  
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
    float solveCase() {
        int N = next<int>(input);
        float left = next<float>(input);
        float curr = next<float>(input);
        for (int i = 1; i < N-1; i++) {
            float right = next<float>(input);
            float avg = (left + right) / 2.0;
            if (curr > avg) curr = avg;
            left = curr;
            curr = right;
        }

        return left; 
    }

    ifstream input;
    ofstream output;
};


int main() {
    Solution sol;
    sol.solve();
    return 0;
}
