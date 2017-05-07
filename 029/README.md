### 029 Divide Two Integers

#### Hint

利用位移。

$dividend = a_0* divisor + a_1* 2*divisor + a_2* 4*divisor + \cdots + a_k* 2^k *divisor$

$ans = a_0*1 + a_1*2 + a_2*2^2 + \cdots + a_k*2^k$

$a_0, a_1, \cdots , a_k \in \{ 0, 1 \}$

注意各种花式边界（WA了无数回）。

