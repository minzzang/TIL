```
 *
 * About
 *
 * Author: minzzang@GitHub (minjjang1117@gmail.com)
 * Date  : 2020-07-20
 * URL   : https://www.acmicpc.net/problem/1463

 *
 *
```

n = int(input())
dp = [0] * n
dp[1] = 1

for i in range(2, n+1):
    dp[i] = dp[i-1] + 1
    if (i % 2 == 0 and (dp[i/2] + 1) < dp[i]):
        dp[i] = dp[i/2] + 1
    if (i % 3 == 0 and (dp[i/3] + 1) < dp[i]):
        dp[i] = dp[i / 3] + 1

print(dp[n+1])

