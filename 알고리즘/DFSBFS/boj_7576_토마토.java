 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-22
  * URL   : https://www.acmicpc.net/problem/7576
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;

    private static StringBuffer sb = new StringBuffer();

    private static Queue<int[]> queue = new LinkedList<>();

    private static int[] dx = {1, -1, 0, 0};

    private static int[] dy = {0, 0, 1, -1};

    private  static int M, N, count, zeroCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        zeroCount = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) zeroCount++;
                if (n == 1) queue.offer(new int[]{i, j, 0});
                arr[i][j] = n;

            }
        }
        bfs();

        if (zeroCount > 0) System.out.println(-1);
        else System.out.println(count);

    }

    private static void bfs() {

        while(!queue.isEmpty()) {
            int[] a = queue.poll();
            count = a[2];

            for (int i=0; i<4; i++) {
                int colX = a[1] + dx[i];
                int colY = a[0] + dy[i];

                if (colX < 0 || colX >= M || colY < 0 || colY >= N || arr[colY][colX] != 0) continue;
                queue.offer(new int[]{colY, colX, a[2] + 1});
                arr[colY][colX] = 1;
                zeroCount--;
            }
        }
    }
}


