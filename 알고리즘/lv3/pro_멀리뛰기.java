 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-22
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12914
  *
  */

class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i=2; i<n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n-1] % 1234567;
    }
}