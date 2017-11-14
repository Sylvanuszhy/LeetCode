### 276 Paint Fence

There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

**Note:**
n and k are non-negative integers.

**Google**

#### Hint

`f[i][0]` 表示使用跟 `i-1` 不同的颜色paint前 `i` 根post的方法数。

`f[i][1]` 表示使用跟 `i-1` 同样的颜色paint前 `i` 根post的方法数。

`f[i][0] = (f[i-1][0]+f[i-1][1])*(k-1)`

`f[i][1] = f[i-1][0]`

