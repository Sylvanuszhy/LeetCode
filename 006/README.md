### 006 ZigZag Conversion

#### Hint

画图。

按zigzag的书写顺序给每个位置编号。每个 `レ` 型为一个block。相邻两个block `|` 部分的序号差（interval）为 `2n-2` 。每个block内除去首末两行，每行至多有2个编号，2个编号的序号差依次为 `2n-4` `2n-6` ··· `2` 。

一行一行处理，根据相邻两个block的序号差和block内的序号差依次从string中拿到下一个char。

特别注意 `nRows=1` 的情况，此时 `interval=0` ，需要特别考虑（第一次提交的时候被坑了）。

#### Time Complexity

设 `len(s)=n` ，O($n$)

