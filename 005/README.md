### 005 Longest Palindromic Substring

#### O($n^2$) Hint

`maxlen1` 为奇数字符回文，`maxlen2` 为偶数字符回文。

枚举回文子串的中间位置，向两边拓展。

#### Time Complexity

设 `len(s)=n` ，O($n^2$)

