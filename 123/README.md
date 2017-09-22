### 123 Best Time to Buy and Sell Stock III

#### Hint

`buy1 = max(buy1, -prices[i])`

`sell1 = max(sell1, buy1+prices[i])`

`buy2 = max(buy2, sell1-prices[i])`

`sell2 = max(sell2, buy2+prices[i])`

