### 011 Container With Most Water

#### Hint

`lHeight` 为左壁高度， `rHeight` 为右壁高度。从两端开始向中间逼近。

左壁右壁在向中间移动的过程中，x轴的长度是在减小的。所以要找到一个更高的height才有可能使面积比原来更大。若 `lHeight<rHeight` ，从左端逼近，找到一个更高的height更新 `lHeight` ；反之从右端逼近，更新  `rHeight` 。计算新的面积并比较，然后进行新的一轮逼近。

#### Time Complexity

设 `len(height)=n` ，O($n$)

