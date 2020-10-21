 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-21
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/42895
  *
  */

class Solution {
    private static int min = 9;
    
    public int solution(int N, int number) {
     dfs(0, 0, N, number);
        return min > 8 ? -1 : min;
    }

    private static void dfs(int depth, long current, long n, int number) {
        if (depth > 8) return;

        if (current == number) {
            min = Math.min(min, depth);
            return;
        }
        for (int i=1; i<=8; i++) {
            dfs(depth+i, current + mul(n, i), n, number);
            dfs(depth+i, current - mul(n, i), n, number);
            dfs(depth+i, current * mul(n, i), n, number);
            dfs(depth+i, current / mul(n, i), n, number);
        }
    }

    private static long mul(long n, int cnt) {
        String str = "";
        for (int i=0; i<cnt; i++) {
            str += n;
        }
        return Long.parseLong(str);
    }
}