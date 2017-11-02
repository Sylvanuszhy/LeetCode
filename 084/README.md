### 084 Largest Rectangle in Histogram

#### Hint

`left[i]` 表示 `i` 往左第一个高度小于 `heights[i]` 的位置

`right[i]` 表示 `i` 往右第一个高度小于 `heights[i]` 的位置

`maxArea = max{(right[i]-left[i]-1)*heights[i]}`

Stack

如果  `heights[i]` 小于栈顶元素位置对应的高度，弹出栈顶，计算面积。 `left=stack.peek(), right=i`

否则 `i` 入栈。

最后增加一个高度为0的块以便清空栈。

