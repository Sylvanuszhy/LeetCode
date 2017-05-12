#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        multimap<string, string> dict;
        vector<string>::iterator itor;
        for (itor = strs.begin(); itor != strs.end(); itor++) {
            vector<char> chs(itor->size());
            chs.assign(itor->begin(), itor->end());
            sort(chs.begin(), chs.end());
            string str;
            str.assign(chs.begin(), chs.end());
            dict.insert({str, *itor});
        }

        string key;
        vector<string> anagrams;
        vector<vector<string>> ans;
        multimap<string, string>::iterator kv;
        for (kv = dict.begin(); kv != dict.end(); kv++) {
            if (kv->first != key) {
                if (anagrams.size()>0) {
                    ans.push_back(anagrams);
                    anagrams.clear();
                }
                key = kv->first;
            }
            anagrams.push_back(kv->second);
        }
        if (anagrams.size()>0)
            ans.push_back(anagrams);

        return ans;
    }
};

int main() {
    Solution solu;
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> ans = solu.groupAnagrams(strs);
}
