 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-23
  * URL   : https://www.acmicpc.net/problem/2146
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static int[][] answer;
    private static Queue<Dot> queue = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N, islandIndex;

    private static class Dot {
        int x;
        int y;
        int step;
        int index;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Dot(int x, int y, int step, int index) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islandIndex = 2;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    changeIslandIndex(i, j);
                    islandIndex++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int index = arr[i][j];
                if (index != 0) {
                    queue.offer(new Dot(j, i, 0, index));
                }
            }
        }

        System.out.println(bfs());
    }

    private static void changeIslandIndex(int y, int x) {
        arr[y][x] = islandIndex;
        queue.offer(new Dot(x, y));

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();

            for (int i=0; i<4; i++) {
                int colX = dot.x + dx[i];
                int colY = dot.y + dy[i];

                if (colX < 0 || colX >= N || colY < 0 || colY >= N) continue;
                if (arr[colY][colX] == 0 || arr[colY][colX] == islandIndex) continue;
                queue.offer(new Dot(colX, colY));
                arr[colY][colX] = islandIndex;
            }
        }
    }

    private static int bfs() {
        int min = 200;

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();

            for (int i=0; i<4; i++) {
                int colX = dot.x + dx[i];
                int colY = dot.y + dy[i];

                if (colX < 0 || colX >= N || colY < 0 || colY >= N) continue;
                if (arr[colY][colX] == 0) {
                    queue.offer(new Dot(colX, colY, dot.step + 1, dot.index));
                    arr[colY][colX] = dot.index;
                    answer[colY][colX] = dot.step + 1;
                } else if (arr[colY][colX] != dot.index) {
                    answer[colY][colX] += dot.step;
                    min = Math.min(min, answer[colY][colX]);
                }
            }
        }
        return min;
    }

}

