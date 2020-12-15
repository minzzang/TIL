 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-15
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/12952
  *
  */

import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int N, COUNT;

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int solution(int n) {
        visited = new boolean[n];
        N = n;

        List<Position> list = new ArrayList<>();
        dfs(0, list);

        return COUNT;
    }

    private static void dfs(int depth, List<Position> list) {
        if (depth == N) {
            COUNT++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            if (isAble(i, depth, list)) {
                list.add(new Position(i, depth));
                dfs(depth + 1, list);
                list.remove(list.size()-1);
            }
            visited[i] = false;
        }
    }

    private static boolean isAble(int i, int depth, List<Position> list) {
        boolean flag = true;
        for (Position p : list) {
            int x = Math.abs(p.x - i);
            int y = Math.abs(p.y - depth);

            if (x == y) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}