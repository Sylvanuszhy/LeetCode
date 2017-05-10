### 031 Next Permutation

#### Hint

参考STL中 `next_permutation` 函数的实现方法。

从末尾向前搜索两个相邻元素，使得 `nums[i]<nums[i+1]` 。然后再从末尾向前搜索第一个元素 `j` ，使得 `nums[i]<nums[j]` 。交换 `nums[i]` 和 `nums[j]` ，并将从 `i+1` 开始到末尾的元素顺序反转。

#### Time Complexity

设 `len(nums)=n` ，O(n)

