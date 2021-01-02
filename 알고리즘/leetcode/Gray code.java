 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-02
  * URL   : https://leetcode.com/problems/gray-code/
  *
  */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    static String[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        grayCode(3);
    }

    public static List<Integer> grayCode(int n) {

        visited = new String[n];
        dfs(0, n);

        return list;
    }

    private static void dfs(int depth, int n) {
        if (depth != 0 && visited[depth-1] == visited[depth]) return;
        if (depth == n) {
            System.out.println(Arrays.toString(visited));
            return;
        }

        visited[depth] = "1";
        dfs(depth+1, n);

        visited[depth] = "0";
        dfs(depth+1, n);
    }

}