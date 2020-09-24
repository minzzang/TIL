 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-24
  * URL   : https://www.acmicpc.net/problem/1780
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;

    private static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        count = new int[3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    private static void divide(int y, int x, int length) {

        if (isSameNum(y, x, length)) {
            count[arr[y][x]+1]++;
        } else {
            int newLength = length / 3;

            for (int i=y; i<y+length; i+=newLength) {
                for (int j=x; j<x+length; j+=newLength) {
                    divide(i, j, newLength);
                }
            }

        }
    }

    private static boolean isSameNum(int y, int x, int length) {
        int num = arr[y][x];

        for (int i=y; i<y+length; i++) {
            for (int j=x; j<x+length; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
