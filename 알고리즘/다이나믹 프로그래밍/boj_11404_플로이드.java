 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-11
  * URL   : https://www.acmicpc.net/problem/11404
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int numberOfbus = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = 100000000;
            }
        }

        for (int i = 1; i <= numberOfbus; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min((dist[i][k] + dist[k][j]), dist[i][j]);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] != 100000000) {
                    sb.append(dist[i][j] + " ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
