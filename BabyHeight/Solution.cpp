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

template< typename T>
vector<T> tokenize(string str, string ch) {
    vector<T> res;
    for(int p1 = 0, p2; p1 < (int)str.size(); p1 = p2+1) {
        p2 = str.find_first_of(ch, p1);
        if(p2 == -1) p2 = str.size();
        if(p2-p1 > 0) {
            T t;
            istringstream is(str.substr(p1, p2-p1));
            is >> t;
            res.push_back(t);
        }
    }
    return res;
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
        string solveCase() {
            float height = (next<char>(input) == 'B') ? 5.f :-5.f;
            vector<int> tokens;
            tokens = tokenize<int>(next<string>(input), "\'\"");
            height += 12 * tokens[0] + tokens[1];
            tokens = tokenize<int>(next<string>(input), "\'\"");
            height += 12 * tokens[0] + tokens[1];
            height /= 2.0;

            ostringstream os;
            height -= 4;
            //cout << "lower: " << height << endl;
            int feet = (int)height/12;
            int inches = (int)ceil(height - 12*feet);
            if (inches == 12) 
                feet +=1, inches = 0;
            os << feet << "\'" << inches << "\"";
            os << " to ";
            height += 8;
            //cout << "upper: " << height << endl;
            feet = (int)height/12;
            inches = (int)floor(height - 12*feet);
            os << feet << "\'" << inches << "\"";
            return os.str();
        }

        ifstream input;
        ofstream output;
};


int main() {
    Solution sol;
    sol.solve();
}
