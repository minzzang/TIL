 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-21
  * URL   : https://www.acmicpc.net/problem/4963
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;

    private static StringBuffer sb = new StringBuffer();

    private static int h, w;

    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};

    private static int[] dy = {-1, 0, 1, -1, 1, -1, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
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

        for (int i=0; i<8; i++) {
            int colX = x + dx[i];
            int colY = y + dy[i];

            if (colX < 0 || colX >= w || colY < 0 || colY >= h || arr[colY][colX] == 0) continue;
            dfs(colY, colX);
        }
    }

}


