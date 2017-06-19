### 106 Construct Binary Tree from Inorder and Postorder Traversal

#### Hint

设待构造的节点在中序遍历中的位置为 `[st,ed]` ，根的位置为 `idx` 。

递归构造左子树 `[st,idx-1]` 和右子树 `[idx+1,ed]` 。

对于前序遍历，设根在前序遍历中的位置为 `pos` 。

左子树（若有）的根在前序遍历中的位置为 `pos+1` 。

右子树（若有）的根在前序遍历中的位置为 `pos+(idx-st)+1` 。

对于后序遍历，设根在后序遍历中的位置为 `pos` 。

左子树（若有）的根在后序遍历中的位置为 `pos+(ed-idx)-1` 。

右子树（若有）的根在后序遍历中的位置为 `pos-1` 。

