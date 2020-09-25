 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-25
  * URL   : https://www.acmicpc.net/problem/2447
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static char[][] arr;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (char[] ch : arr) {
            Arrays.fill(ch, ' ');
        }

        divide(0, 0, N);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int y, int x, int size) {

        if (size == 1) {
            arr[y][x] = '*';
        } else {
            int newSize = size / 3;
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (i==1 && j==1) continue;
                    divide(y+(newSize*i), x+(newSize*j), newSize);
                }
            }
        }
    }

}


