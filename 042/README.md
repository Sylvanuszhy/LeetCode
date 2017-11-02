### 042 Trapping Rain Water

#### Hint

最大值左侧：如果 `height[i]<height[j]` ， `i` 和 `j` 之间就能trap rain water `height[i]*(j-i-1)` 减去 `i` 和 `j` 之间的低方块。

最大值右侧类推。

#### Time Complexity

O(n)

