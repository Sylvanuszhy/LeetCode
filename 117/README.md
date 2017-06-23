### 117 Populating Next Right Pointers in Each Node II

#### Hint

指针p遍历前一层（已更新next指针），指针q跟随p更新当前层的next指针。

用指针h记录当前层的第一个节点，遍历完后赋值给p，重复。

