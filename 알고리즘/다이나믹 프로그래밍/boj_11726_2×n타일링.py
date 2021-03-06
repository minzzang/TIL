```
 *
 * About
 *
 * Author: minzzang@GitHub (minjjang1117@gmail.com)
 * Date  : 2020-07-21
 * URL   : https://www.acmicpc.net/problem/11726

 *
 *
```

n = int(input())
dp = [0] * (n+2)

dp[1] = 1
dp[2] = 2

for i in range(3, n+1):
    dp[i] = (dp[i-2] + dp[i-1]) % 10007

print(dp[n])
