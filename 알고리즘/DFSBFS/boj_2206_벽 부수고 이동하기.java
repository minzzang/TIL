 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-25
  * URL   : https://www.acmicpc.net/problem/2206
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] visited, map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};


    private static class Point {
        int x;
        int y;
        int distance;
        int drill;

        Point(int x, int y, int distance, int drill) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j+1] = str.charAt(j) - '0';
                visited[i][j+1] = Integer.MAX_VALUE;
            }
        }

        int minDistance = bfs(1, 1);
        System.out.println(minDistance);
    }

    private static int bfs(int col, int row) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(col, row, 1, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == M && point.y == N) {
                return point.distance;
            }

            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + point.x;
                int newY = dy[i] + point.y;

                if (newX < 1 || newX > M || newY < 1 || newY > N) continue;
                if (visited[newY][newX] <= point.drill) continue;

                if (map[newY][newX] == 0) {
                    queue.offer(new Point(newX, newY, point.distance+1, point.drill));
                    visited[newY][newX] = point.drill;
                } else {
                    if (point.drill == 0) {
                        queue.offer(new Point(newX, newY, point.distance+1, point.drill+1));
                        visited[newY][newX] = point.drill+1;
                    }
                }
            }
        }
        return -1;
    }

}