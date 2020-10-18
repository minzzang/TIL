 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12945
  *
  */

class Solution {
    public int solution(int n) {
    int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }

        return dp[n] % 1234567;
    }
}