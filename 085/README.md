### 085 Maximal Rectangle

#### Hint

`if matrix[i][j]=='1'` :

`height[i][j] = height[i-1][j]+1`

`left[i][j] = max(left[i-1][j], rLeft)`

`right[i][j] = min(right[i-1][j], rRight)`

