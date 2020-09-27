 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-27
  * URL   : https://www.acmicpc.net/problem/2448
  *
  */

import java.io.*;
import java.util.Arrays;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    private static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N*2-1];
        for (char[] i : arr) {
            Arrays.fill(i, ' ');
        }

        star(0, N-1, N);

        for (int i=0; i<N; i++) {
            bw.write(arr[i]);
            bw.write('\n');
        }
        bw.flush();

    }

    private static void star(int y, int x, int n) {
        if (n == 3) {
            arr[y][x] = '*';
            arr[y+1][x-1] = arr[y+1][x+1] = '*';
            arr[y+2][x-2] = arr[y+2][x-1] = arr[y+2][x] = arr[y+2][x+1] = arr[y+2][x+2] = '*';
        } else {
            star(y, x, n/2);
            star(y+(n/2), x-(n/2), n/2);
            star(y+(n/2), x+(n/2), n/2);
        }
    }

}