 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12905
  *
  */

class Solution
{
    public int solution(int [][]board)
    {
    int height = board.length;
        int width = board[0].length;
        int[][] dp = new int[height][width];
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                    continue;
                }
                if (board[i][j] != 0) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        int answer = 0;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }
}