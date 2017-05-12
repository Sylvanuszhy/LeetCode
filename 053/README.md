### 053 Maximum Subarray

#### Hint

动态规划。 `maxSum[i]` 表示subarray末尾为 `i` 的最大和。

`maxSum[i] = max(maxSum[i-1]+nums[i], nums[i])` 

#### Time Complexity

设 `len(nums)=n` ，O(n)

