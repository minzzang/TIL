 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-27
  * URL   : https://www.acmicpc.net/problem/14503
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int height, width, count = 1;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        arr = new int[height][width];

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i=0; i<height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<width; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val == 1 ? -1 : val;
            }
        }

        clean(row, col, direction);
        System.out.println(count);
    }

    private static void clean(int row, int col, int direction) {
        arr[row][col] = 1;

        for (int i=0; i<4; i++) {
            direction = (direction + 3) % 4;
            int newRow = row + dy[direction];
            int newCol = col + dx[direction];

            if (arr[newRow][newCol]==0) {
                count++;
                clean(newRow, newCol, direction);
                return;
            }
        }

        int back = (direction+2) % 4;
        int backRow = row + dy[back];
        int backCol = col + dx[back];

        if (arr[backRow][backCol] != -1) {
            clean(backRow, backCol, direction);
        }
    }

}


