 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-19
  * URL   : https://www.acmicpc.net/problem/10451
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] arr;

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- != 0) {
            int V = Integer.parseInt(br.readLine());
            arr = new int[V+1];
            visited = new boolean[V+1];
            st = new StringTokenizer(br.readLine());

            for (int i=1; i<=V; i++) {
                int v = Integer.parseInt(st.nextToken());
                arr[i] = v;
            }

            int count = 0;
            for (int i=1; i<=V; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);

        }

    }

    private static void dfs(int v) {
        visited[v] = true;

        if (!visited[arr[v]]) {
            dfs(arr[v]);
        }
    }

}