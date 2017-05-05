### 003 Longest Substring Without Repeating Characters

#### Hint

`maxlen[i]` 表示到i位置无重复字符子串的最大长度（初始化为0）。用hash表记录目前为止某字符出现的最后位置。

第一遍遍历，若当前字符已经在hash表中有记录，则 `maxlen[i] = current_pos - pos_in_hash` ，同时更新hash表中字符的位置为当前位置；否则仅在hash表中记录新出现字符的位置。

第二遍遍历，若 `maxlen[i] = 0` （没有在第一遍遍历中被更新），则 `maxlen[i] = maxlen[i-1]+1` ；否则 `maxlen[i] = min(maxlen[i], maxlen[i-1]+1)` 。

第三遍遍历，取 `maxlen` 中的最大值即为答案。

#### Time Complexity

设 `len(s)=n` ，3遍 O($n$)

