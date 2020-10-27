 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-27
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/1832
  *
  */

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
         int answer = 0;
        int[][] right = new int[m+1][n+1];
        int[][] down = new int[m+1][n+1];

        right[0][1] = down[0][1] = 1;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (cityMap[i][j] == 0) {
                    right[i+1][j+1] = (right[i+1][j] + down[i][j+1]) % MOD;
                    down[i+1][j+1] = (right[i+1][j] + down[i][j+1]) % MOD;
                } else if (cityMap[i][j] == 2) {
                    right[i+1][j+1] = right[i+1][j] % MOD;
                    down[i+1][j+1] = down[i][j+1] % MOD;
                } else {
                    continue;
                }
            }
        }

        answer = right[m][n] % MOD;
        return answer;
    }
}