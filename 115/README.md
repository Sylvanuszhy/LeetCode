### 115 Distinct Subsequences

#### Hint

`f[i,j]` 表示和 `t[0..j]` 匹配成功的 `s[0..i]` 的子序列数。

状态转移方程：

initialization: `f[i,-1] = 1`

`f[i,j] = f[i-1,j]+f[i-1,j-1]`  if `s[i]==t[j]`

`f[i,j] = f[i-1,j]`  if `s[i]!=t[j]`

