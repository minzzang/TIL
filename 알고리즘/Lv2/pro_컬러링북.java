 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/1829
  *
  */

class Solution {
    private static int[][] arr;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int M, N, count;
    
    public int[] solution(int m, int n, int[][] picture) {
     int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m;
        N = n;
        arr = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = picture[i][j];
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] != 0) {
                    findSameArea(i, j, (int) arr[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    numberOfArea++;
                    count = 0;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void findSameArea(int y, int x, int num) {
        arr[y][x] = 0;
        count++;

        for (int i=0; i<4; i++) {
            int colX = dx[i] + x;
            int colY = dy[i] + y;

            if (colX < 0 || colX > N-1 || colY < 0 || colY > M-1) continue;
            if (arr[colY][colX] != num) continue;
            findSameArea(colY, colX, num);
        }

    }
}