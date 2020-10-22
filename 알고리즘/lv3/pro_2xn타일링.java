 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12900
  *
  */

class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }
        return dp[n-1] % 1000000007;
    }
}