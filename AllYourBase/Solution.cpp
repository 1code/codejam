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
    unsigned long long solveCase() {
        string str;
        cin >> str;
        //cout << str << endl;
        int N = str.size();
        if (N == 1) return 1;
        vector<int> hash(256, -1);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int j = str[i];
            if (hash[j] == -1)
                hash[j] = count++;
        }
        //cout << count << endl;
        if (count == 1) count = 2;

        unsigned long long digits = 1;
        for (int i = 1; i < N; i++) {
            digits *= count;
        }
        //cout << digits << endl;

        unsigned long long res = 0;
        for (int i = 0; i < N; i++) {
            int j = str[i];
            unsigned long long num = hash[j];
            if (num == 0) num = 1;
            else if (num == 1) num = 0;
            res += num * digits;
            digits /= count;
        }
        
        return res;
    }

     
    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}
