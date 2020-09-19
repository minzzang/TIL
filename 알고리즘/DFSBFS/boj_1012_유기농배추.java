 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-19
  * URL   : https://www.acmicpc.net/problem/1012
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;

    private static int[] dx = {1, -1, 0, 0};

    private static int[] dy = {0, 0, 1, -1};

    private static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[v][u] = 1;
            }

            int count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }

    }

    private static void dfs(int y, int x) {
        arr[y][x] = 0;

        for (int i=0; i<4; i++) {
            int colX = x + dx[i];
            int colY = y + dy[i];

            if (colX < 0 || colX >= M || colY < 0 || colY >= N || arr[colY][colX] == 0) continue;
            dfs(colY, colX);
        }
    }

}


