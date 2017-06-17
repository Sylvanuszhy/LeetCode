### 096 Unique Binary Search Trees

#### Hint

设 `f[i]` 表示 `n=i` 时的种类数。

枚举根节点， `f[i] += f[left]*f[right]` 

