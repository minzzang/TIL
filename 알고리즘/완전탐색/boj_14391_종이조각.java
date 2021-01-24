 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-01-24
  * URL   : https://www.acmicpc.net/problem/14391
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int n, m, MAX;
    static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        papers = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                papers[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n * m];
        dfs(0);

        System.out.println(MAX);
    }

    private static void dfs(int index) {
        if (index == n * m) {
            getMax();
            MAX = Math.max(MAX, getMax());
            return;
        }

        visited[index] = true;
        dfs(index + 1);

        visited[index] = false;
        dfs(index + 1);
    }

    private static int getMax() {
        int index = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                if (visited[index++]) {
                    temp = temp * 10 + papers[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            if (temp != 0) sum += temp;
        }

        for (int i = 0; i < m; i++) {
            int temp = 0;
            index = i;
            for (int j = 0; j < n; j++) {
                if (!visited[index]) {
                    temp = temp * 10 + papers[j][i];
                } else {
                    sum += temp;
                    temp = 0;
                }
                index += m;
            }
            if (temp != 0) sum += temp;
        }
        return sum;
    }

}
