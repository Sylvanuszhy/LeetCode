### 142 Linked List Cycle II

#### Hint

快指针和慢指针相遇节点为 `m` ，环起点为 `n` ，链表起点为 `s` ，环长为 `c` 。

设 `sm=k` ， `k=2k-k=tc` 。两个指针分别从 `s` 和 `m` 出发，经过 `sm-mn=k-mn=tc-mn=sn` 后同时到达 `n` 。

