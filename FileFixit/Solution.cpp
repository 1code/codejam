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
    int solveCase() {
        int N = next<int>(input);
        int M = next<int>(input);
        Node root;
        int res = 0;
        for (int i = 0; i < N; i++) {
            vector<string> path = tokenize<string>(next<string>(input), "/");
            Node::addNode(root, path, 0, res, false); 
        }

        for (int i = 0; i < M; i++) {
            vector<string> path = tokenize<string>(next<string>(input), "/");
            Node::addNode(root, path, 0, res, true);
        }

        return res;
    }
    
    class Node {
    public:
        static void addNode(Node & node, vector<string> & path, size_t i, int & res, bool make) {
            if (i == path.size())
                return;
            if (node.next.find(path[i]) == node.next.end()) {
                node.next[path[i]] = Node();
                if (make) res++;
            }
            addNode(node.next[path[i]], path, i+1, res, make);
        }
    private:
        map<string, Node> next;
    };

    ifstream input;
    ofstream output;
};


int main() {
    Solution sol;
    sol.solve();
}
