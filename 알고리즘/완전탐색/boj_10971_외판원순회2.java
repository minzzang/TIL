 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-28
  * URL   : https://www.acmicpc.net/problem/10971
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int MIN = Integer.MAX_VALUE, N;
    private static boolean[] visited;
    private static int[][] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cities = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(MIN);

    }

    private static void dfs(int start, int city, int depth, int sum) {
        if (depth == N-1) {
            if (cities[city][start] == 0) return;
            MIN = Math.min(MIN, sum + cities[city][start]);
            return;
        }

        visited[city] = true;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (cities[city][i] != 0) {
                dfs(start, i,depth+1, sum + cities[city][i]);
            }
        }
        visited[city] = false;
    }
}