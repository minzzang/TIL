 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-14
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12907
  *
  */

class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length+1][n+1];

        for (int i = 0; i <= money.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= money.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (money[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = (dp[i][j] + dp[i-1][j] + dp[i][j-money[i-1]]) % 1000000007;
            }
        }
        return dp[money.length][n] % 1000000007;
    }
}