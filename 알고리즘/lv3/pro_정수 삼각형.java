 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-17
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43105
  *
  */

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
                dp[i][j] += triangle[i][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}