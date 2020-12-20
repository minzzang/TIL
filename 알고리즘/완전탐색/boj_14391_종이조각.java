 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-20
  * URL   : https://www.acmicpc.net/problem/14391
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] paper = new char[N][M];

        String[] x = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            x[i] = str;
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j);
            }
        }

        String[] y = new String[M];
        for (int i = 0; i < M; i++) {
            String str = "";
            for (int j = 0; j < N; j++) {
                str += paper[j][i];
            }
            y[i] = str;
        }

        int xSum = 0;
        for (int i = 0; i < x.length; i++) {
            xSum += Integer.parseInt(x[i]);
        }

        int ySum = 0;
        for (int i = 0; i < y.length; i++) {
            ySum += Integer.parseInt(y[i]);
        }
        System.out.println(Math.max(xSum, ySum));
    }
}