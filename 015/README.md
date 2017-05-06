### 015 3Sum

#### Hint

跟TwoSum类似。需要注意的是答案要去重。

首先排序。枚举target。num1和num2从两侧逼近。找到答案后num1和num2分别跳过相等的数。同样的，当前target搜索完成后也跳过相等的数。

注意下标越界（被坑了2次）。

#### Time Complexity

设 `len(nums)=n` ，O($n^2$)

