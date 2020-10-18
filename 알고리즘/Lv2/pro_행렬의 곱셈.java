 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-18
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12949
  *
  */

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
       int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i=0; i<arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    int num = arr1[i][k];
                    sum += num * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}