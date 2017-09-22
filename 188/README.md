### 188 Best Time to Buy and Sell Stock IV

#### Hint

`f[i,j]` 表示到第 `i` 天进行 `j` 次交易的最大利润。 `checking` 保存买入新的股票时最大的剩余资金。

状态转移方程：

`f[i,j] = max(f[i-1,j], checking+prices[i])`

`checking = max(checking, f[i-1,j-1]-prices[i])`

#### Time Complexity

O(nk)

