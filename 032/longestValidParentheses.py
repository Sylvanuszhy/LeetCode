class Solution:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        f = [None]*len(s)
        for i, c in enumerate(s):
            if i == 0:
                f[i] = 0
                continue
            if c == '(':
                f[i] = 0
            elif c == ')':
                lPos = i-f[i-1]-1
                if lPos>=0 and s[lPos] == '(':
                    f[i] = f[i-1]+2
                    if lPos-1>=0:
                        f[i] += f[lPos-1]
                else:
                    f[i] = 0
        if len(s)>0:
            return max(f)
        else:
            return 0

if __name__ == '__main__':
    solu = Solution()
    s = "(()))())("
    maxLen = solu.longestValidParentheses(s)
    print(maxLen)
