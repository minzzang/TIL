 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-20
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17679
  *
  */

class Solution {
    public int solution(int m, int n, String[] board) {
       char[][] ch = new char[n][m];
        boolean[][] visited;

        for (int i=0; i<m; i++) {
            String str = board[i];
            for (int j=0; j<n; j++) {
                ch[j][i] = str.charAt(j);
            }
        }


        int answer = 0;
        while (true) {
            visited = new boolean[n][m];
            boolean flag = false;
            for (int i=0; i<n-1; i++) {
                for (int j=0; j<m-1; j++) {
                    if (ch[i][j] == '0') continue;

                    if (ch[i][j] == ch[i][j+1] && ch[i][j] == ch[i+1][j] && ch[i][j] == ch[i+1][j+1]) {
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;

                        flag = true;
                    }
                }
            }

            if (!flag) break;

            for (int i=0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    if (visited[i][j]) answer++;
                }
            }

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (visited[i][j]) {
                        if (j == 0) {
                            ch[i][j] = '0';
                            continue;
                        }
                        for (int k=j-1; k>=0; k--) {
                            ch[i][k + 1] = ch[i][k];
                            ch[i][k] = '0';
                        }
                    }
                }
            }
        }
        return answer;
    }
}