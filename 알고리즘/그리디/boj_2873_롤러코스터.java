 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-08
  * URL   : https://www.acmicpc.net/problem/2873
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] arr;
    private static StringBuffer sb = new StringBuffer();
    private static int minX, minY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 1000;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if ((i-j) % 2 == 1) {
                    if (min > arr[i][j]) {
                        min = arr[i][j];
                        minX = j;
                        minY = i;
                    }
                }
            }
        }

        if (R % 2 == 1) {
            moveRight(0, R, C);
        } else if (C % 2 == 1) {
            moveDown(R, C);
        } else {
           moveRight(0, minY, C);
           moveZigzag(minY-1, C);
           moveRight(minY+2, R, C);
        }
        System.out.println(sb);

    }

    private static void moveRight(int index, int r, int c) {
        for (int i=index; i<r; i++) {
            for (int j=index; j<c-1; j++) {
                if (i % 2 == 0) {
                    sb.append('R');
                } else {
                    sb.append('L');
                }
            }
            if (i != r-1) sb.append('D');
        }
    }

    private static void moveDown(int r, int c) {
        for (int i=0; i<c; i++) {
            for (int j=0; j<r-1; j++) {
                if (i % 2 == 0) {
                    sb.append('D');
                } else {
                    sb.append('U');
                }
            }
            if (i != r-1) sb.append('R');
        }
    }

    private static void moveZigzag(int r, int c) {
        for (int i=0; i<c-1; i++) {
            for (int j=r; j<r+1; j++) {
                if (i == minX && j == minY) {
                    if (r % 2 == 0) {
                        if (i != r-1) sb.append('R');
                    } else {
                        if (i != r-1) sb.append('L');
                    }
                    continue;
                }
                if (r % 2 == 0) {
                    if (i % 2 == 0) {
                        if (i == minX && j+1 == minY) sb.append('R');
                        sb.append('D');
                    } else {
                        if (i == minX && j-1 == minY) sb.append('L');
                        sb.append('U');
                    }
                } else {
                    if (i % 2 == 0) {
                        if (i == minX && j-1 == minY) sb.append('L');
                        sb.append('U');
                    } else {
                        if (i == minX && j+1 == minY) sb.append('R');
                        sb.append('D');
                    }
                }
            }
            if (r % 2 == 0) {
                if (i != r-1) sb.append('R');
            } else {
                if (i != r-1) sb.append('L');
            }
        }
    }
}