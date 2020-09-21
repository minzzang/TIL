 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-21
  * URL   : https://www.acmicpc.net/problem/11724
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] list;

    private static StringBuffer sb = new StringBuffer();

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        list = new ArrayList[N+1];
        for (int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;
            dfs(i);
            count++;
        }
        System.out.println(count);

    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i : list[start]) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }

}


