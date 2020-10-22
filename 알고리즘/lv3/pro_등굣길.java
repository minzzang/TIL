 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42898
  *
  */

class Solution {
    public int solution(int m, int n, int[][] puddles) {
    int[][] dp = new int[n+1][m+1];
        dp[0][1] = 1;

        for (int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                int a = dp[i-1][j] % 1000000007;
                int b = dp[i][j-1] % 1000000007;
                dp[i][j] = (a + b) % 1000000007;
            }
        }
        return dp[n][m] % 1000000007;
    }
}