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
        input = freopen("data.in", "r" , stdin);
        output = freopen("data.out", "w" , stdout);
    }

    void solve() {
        int T;
        cin >> T;
        for(int i = 1; i <= T; i++)  {
            cout << "Case #" << i << ": " << solveCase() << endl;
        }
    }

private:
    int solveCase() {
        long long A, B;
        cin >> A >> B;

        int res = 0;
        
        long long root = sqrt(A);
        if (isPalindrome(root) && isPalindrome(A) && root*root == A)
            res++;
       
        ostringstream os;
        os << root;
        string str = os.str();
        while (true) {
            nextPalindrome(str);
            istringstream is(str);
            is >> root;
            long long prod = root*root;
            if (prod > B)
                break;
            if (isPalindrome(prod))
                res++;
        }

        return res;
    }
   
    long long sqrt(long long x) {
        if(x < 2) return x;
        long long l = 0;
        long long u = 1 + (x / 2); 
        while(l+1 < u) {
            long long m = l + (u - l) / 2;
            long long p = m * m;
            if (p == x) 
                return m;
            if(p > x)
                u = m;
            else
                l = m;
        }
        return l;
    } 
    
    bool isPalindrome(long long x) {
        if (x < 0) return false;
        long long d = 1;
        while (x / d >= 10) d *= 10; 
        while (x != 0) {
            long long l = x / d;
            long long r = x % 10; 
            if (l != r) return false;
            x = (x % d) / 10; 
            d /= 100;
        }   
        return true;
    }   

    void nextPalindrome(string & num) {   
        string org(num);
        int begin = 0;
        int end = num.size() - 1;
        while (begin < end)
            num[end--] = num[begin++];
        if (begin > end)
            begin--, end++;
        if (!isGreater(num, org))
            increase(num, begin, end);
    }   

    bool isGreater(string & v1, string & v2) {
        if (v1.size() != v2.size())
            return v1.size() > v2.size();
        for (size_t i = 0; i < v1.size(); i++)
            if (v1[i] != v2[i])
                return v1[i] > v2[i];
        return false;
    }   

    void increase(string & num, int begin, int end) {
        if (begin < 0) {   
            num[num.size() - 1] = '1';
            num.insert(num.begin(), '1'); 
            return;
        }

        if (num[begin] < '9') {   
            num[begin] = num[end] = num[begin] + 1;
            return;
        }

        num[begin] = num[end] = '0';
        increase(num, begin-1, end+1);
        return;
    }

    FILE * input;
    FILE * output;
};

int main() {
    Solution sol;
    sol.solve();
}
