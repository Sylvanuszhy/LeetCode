### 198 House Robber

#### Hint

`f[i]` 表示抢房子 `i` 时获得的最大钱数， `nf[i]` 表示不抢房子 `i` 时获得的最大钱数。

状态转移方程：

`f[i] = max(f[i-2], nf[i-1])+nums[i]`

`nf[i] = max(f[i-1], nf[i-1])`

