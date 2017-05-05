### 001 Two Sum

#### Hint

遍历列表，用hash表记录每个数出现的位置。每读到一个数，查询 `target-num` 是否在hash表中出现，若出现，则找到pair，输出该数的位置和当前读到的位置；否则记录当前数的位置，继续遍历。

#### Time Complexity

设 `len(nums)=n` ，O($n$)

