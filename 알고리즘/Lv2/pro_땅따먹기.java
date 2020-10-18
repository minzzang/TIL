 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12913
  *
  */

class Solution {
    
    int solution(int[][] land) {
   for (int i=1; i<land.length; i++) {
            for (int j=0; j<4; j++) {
                land[i][j] += getMaxGrade(land, i-1, j);
            }
        }

        int max = 0;
        for (int j=0; j<4; j++) {
                max = Math.max(max, land[land.length-1][j]);
            }

        return max;
    }

    private static int getMaxGrade(int[][] land, int height, int width) {
        int max = 0;
        for (int i=0; i<4; i++) {
            if (i == width) continue;
            max = Math.max(max, land[height][i]);
        }

        return max;
    }
}