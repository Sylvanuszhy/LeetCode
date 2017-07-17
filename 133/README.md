### 133 Clone Graph

#### Hint

BFS。

用一个label映射到vertex的hash表保存已new的vertex。如果边的另一端vertex不在hash表中，则new一个vertex，并把它加入到BFS队列中；否则直接从hash表中取出vertex连接。

