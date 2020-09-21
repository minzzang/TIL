 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-21
  * URL   : https://www.acmicpc.net/problem/11725
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] list;

    private static StringBuffer sb = new StringBuffer();

    private static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        parents = new int[N+1];

        dfs(1, 0);
        for (int i=2; i<parents.length; i++) {
            sb.append(parents[i] + "\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int start, int parent) {
        parents[start] = parent;

        for (int i : list[start]) {
            if (i != parent) dfs(i, start);
        }

    }

}


