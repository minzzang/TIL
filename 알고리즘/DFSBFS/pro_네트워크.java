 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-06
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/43162
  *
  */

class Solution {

    private static boolean[] d;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        dfs(computers, 0);
        return answer;
    }

    private static void dfs(int[][] computers, int index) {
         if (d[index] == false) {
            d[index] = true;
         }

    }
}
