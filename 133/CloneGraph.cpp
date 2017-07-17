#include <iostream>
#include <vector>
#include <queue>
#include <map>
using namespace std;

struct UndirectedGraphNode {
    int label;
    vector<UndirectedGraphNode *> neighbors;
    UndirectedGraphNode(int x) : label(x) {};
};

class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if (node == NULL)
            return NULL;
        map<int, UndirectedGraphNode *> dict;
        UndirectedGraphNode *st = new UndirectedGraphNode(node->label);
        dict.insert({st->label, st});
        queue<UndirectedGraphNode *> ori;
        queue<UndirectedGraphNode *> clo;
        ori.push(node);
        clo.push(st);
        while (!ori.empty()) {
            UndirectedGraphNode *o = ori.front();
            UndirectedGraphNode *c = clo.front();
            ori.pop();
            clo.pop();

            vector<UndirectedGraphNode *>::iterator itor;
            for (itor = o->neighbors.begin(); itor != o->neighbors.end(); itor++) {
                UndirectedGraphNode *neighbor = *itor;
                map<int, UndirectedGraphNode *>::iterator pos = dict.find(neighbor->label);
                if (pos == dict.end()) {
                    UndirectedGraphNode *n = new UndirectedGraphNode(neighbor->label);
                    dict.insert({n->label, n});
                    c->neighbors.push_back(n);
                    ori.push(neighbor);
                    clo.push(n);
                } else {
                    c->neighbors.push_back(pos->second);
                }
            }
        }
        return st;
    }
};

int main() {
    Solution solu;
    solu.cloneGraph(NULL);
}
