 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-23
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/60062
  *
  */

class Solution {
    private static int N;
    private static boolean FINISH = false;
    private static boolean[] visited;
    private static int[] choice;
    private static int[][] weakList;
    
    public int solution(int n, int[] weak, int[] dist) {
        int length = weak.length;
        N = n;
        weakList = new int[length][length];
        setWeakList(weak);

        visited = new boolean[dist.length];
        for (int i = 1; i <= dist.length; i++) {
            int friends = i;
            choice = new int[friends];
            permutation(0, friends, dist);

            if (FINISH) return friends;
        }

        return -1;
    }

    private static void permutation(int depth, int friends, int[] dist) {
        if (FINISH) return;
        if (depth == friends) {
            check();
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            choice[depth] = dist[i];
            permutation(depth + 1, friends, dist);
            visited[i] = false;
        }
    }

    private static boolean check() {
        for (int[] weak : weakList) {
            boolean[] check = new boolean[weak.length];
            int start = 0;

            for (int i = 0; i < choice.length; i++) {
                for (int j = 0; j < weak.length; j++) {
                    if (check[j]) continue;

                    if (weak[j] <= weak[start] + choice[i]) {
                        check[j] = true;
                    } else {
                        start = j;
                        break;
                    }
                }
            }

            if (isFinished(check)) {
                FINISH = true;
                return true;
            }
        }
        return false;
    }

    private static boolean isFinished(boolean[] check) {
        for (boolean b : check) {
            if (!b) return false;
        }
        return true;
    }

    private static void setWeakList(int[] weak) {
        int rowLength = weakList.length;
        int colLength = weakList[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i + j >= colLength) {
                    weakList[i][j] = weak[(j+i) % colLength] + N;
                } else {
                    weakList[i][j] = weak[j+i];
                }
            }
        }
    }
}
