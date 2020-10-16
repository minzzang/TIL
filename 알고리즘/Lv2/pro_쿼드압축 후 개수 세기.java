 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-16
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/68936
  *
  */

class Solution {
    private static int[] count = {0, 0};
    
    public int[] solution(int[][] arr) {
         int n = arr.length;
        compress(arr, 0, 0, n);
        return count;

    }

    private static void compress(int[][] arr, int height, int width, int n) {
        int one = arr[height][width];
        if (n == 1) {
            count[one]++;
            return;
        }

        boolean flag = true;

        for (int i=height; i<height + n; i++) {
            for (int j=width; j<width + n; j++) {
                if (one != arr[i][j]) {
                    compress(arr, height, width, n/2);
                    compress(arr, height, width+(n/2), n/2);
                    compress(arr, height+(n/2), width, n/2);
                    compress(arr, height+(n/2), width+(n/2), n/2);
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        if (flag) {
            count[one]++;
        }
    }
}