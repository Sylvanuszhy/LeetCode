class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        set<string> s = {"+", "-", "*", "/"};
        stack<int> vals;
        for (int i = 0; i<tokens.size(); i++)
            if (s.find(tokens[i]) != s.end()) {
                int b = vals.top();
                vals.pop();
                int a = vals.top();
                vals.pop();
                if (tokens[i] == "+")
                    vals.push(a+b);
                if (tokens[i] == "-")
                    vals.push(a-b);
                if (tokens[i] == "*")
                    vals.push(a*b);
                if (tokens[i] == "/")
                    vals.push(a/b);
            } else {
                int a = atoi(tokens[i].c_str());
                vals.push(a);
            }
        return vals.top();
    }
};
