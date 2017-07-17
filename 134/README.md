### 134 Gas Station

#### Hint

问题可以转化为：序列 `gas[i]-cost[i]` 从位置k开始累加一圈，任何时候都非负。

把序列扩充1倍。从头开始累加序列，用 `low` 保存目前为止出现的最小值。若从累加值从 `k` 到 `k+n-1` 都大于 `low` ，则位置 `k` 出发是一个可行解。

#### Time Complexity

设 `len(gas)=n` ，O($n$)

