### 138 Copy List with Random Pointer

#### Hint

第一遍循环拷贝next pointer。

用一个hash表保存从原始node到拷贝node的映射。这样拷贝random pointer时就可以直接取出对应的拷贝node。

