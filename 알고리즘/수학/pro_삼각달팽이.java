 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-09
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/68645
  *
  */

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];

        int y = -1;
        int x = 0;
        int count = 1;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (i % 3 == 0) {
                    y++;
                } else if (i % 3 == 1) {
                    x++;
                } else {
                    x--;
                    y--;
                }
                arr[y][x] = count++;
            }
        }

        int num = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] != 0) {
                    answer[num++] = arr[i][j];
                }
            }
        }

        return answer;
    }
}