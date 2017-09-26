### 128 Longest Consecutive Sequence

#### Hint

HashMap保存number->len

新来一个数字 `k` ：

如果HashMap中存在 `k` ，说明 `k` 在sequence中间，continue

从HashMap中取出 `k-1` 和 `k+1` 对应的长度 `leftLen` 和 `rightLen` ，新的长度为 `leftLen+1+rightLen` ，更新sequence最左端 `k-leftLen` 和最右端 `k+rightLen` 保存的长度。

