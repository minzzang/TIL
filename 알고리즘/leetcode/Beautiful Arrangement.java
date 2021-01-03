 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-03
  * URL   : https://leetcode.com/problems/beautiful-arrangement
  *
  */

class Solution {
    static boolean[] visited;
    
    public int countArrangement(int n) {
        visited = new boolean[n+1];
        int count = 0;
        count += dfs(1, n);

        return count;   
    }
    
    private static int dfs(int depth, int n) {
        int count = 0;
        if (depth == n + 1) {
            return 1;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            if (i % depth == 0 || depth % i == 0) {
                visited[i] = true;
                count += dfs(depth + 1, n);
                visited[i] = false;
            }
        }
        return count;
    }
}