 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-19
  * URL   : https://www.acmicpc.net/problem/1260
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> list = new ArrayList<>();

    private static boolean[] visited;

    private static StringBuffer sb = new StringBuffer();

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (List l : list) {
            Collections.sort(l);
        }

        dfs(V-1);
        visited = new boolean[N];
        sb.append("\n");
        bfs(V-1);
        System.out.println(sb);

    }

    private static void dfs(int v) {

        visited[v] = true;
        sb.append(v+1 + " ");

        for (Integer i : list.get(v)) {
            if (visited[i]) continue;
            dfs(i);
        }
    }

    private static void bfs(int v) {
        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            sb.append(n+1 + " ");

            for (Integer i : list.get(n)) {
                if (visited[i]) continue;

                queue.offer(i);
                visited[i] = true;
            }
        }

    }

}