 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-26
  * URL   : https://www.acmicpc.net/problem/1707
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int V, E;
    private static int[] visited;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            int[] parents = new int[V+1];
            for (int i = 1; i <= V; i++) {
                parents[i] = i;
            }

            list = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            visited = new int[V+1];
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    dfs(2,i);
                }
            }

            boolean answer = true;
            for (int i = 1; i <= V; i++) {
                for (int j : list.get(i)) {
                    if (visited[i] == visited[j]) {
                        answer = false;
                        break;
                    }
                }
            }

            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    private static void dfs(int prev, int v) {
        int now = switchFlag(prev);
        visited[v] = now;
        for (int i : list.get(v)) {
            if (visited[i] == 0) {
                dfs(now, i);
            }
        }
    }

    private static int switchFlag(int flag) {
        return flag == 1 ? 2 : 1;
    }

}