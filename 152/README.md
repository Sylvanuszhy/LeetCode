### 152 Maximum Product Subarray

#### Hint

维护 `maxVal` ， `minVal` 两个变量。如果当前值 `num[i]` 大于0， `maxVal=maxVal*num[i], minVal=minVal*num[i] ` ；否则 `maxVal=minVal*num[i], minVal=maxVal*num[i] ` 

