 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-27
  * URL   : https://www.acmicpc.net/problem/14500
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, MAX = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, map[i][j]);
                calculateExceptionBlock(i, j);
            }
        }
        System.out.println(MAX);

    }

    private static void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= M || newY < 0 || newY >= N) continue;
            if (visited[newY][newX]) continue;

            visited[newY][newX] = true;
            dfs(newY, newX, depth+1, sum + map[newY][newX]);
            visited[newY][newX] = false;
        }
    }

    private static void calculateExceptionBlock(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int sum = map[y][x];
            boolean flag = true;

            for (int j = 0; j < 3; j++) {
                int newX = x + dx[(i + j) % 4];
                int newY = y + dy[(i + j) % 4];

                if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
                    flag = false;
                    break;
                }

                sum += map[newY][newX];
            }
            if (flag) MAX = Math.max(MAX, sum);
        }
    }
}