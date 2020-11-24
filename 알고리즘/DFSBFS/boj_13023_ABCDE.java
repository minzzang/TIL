 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-24
  * URL   : https://www.acmicpc.net/problem/13023
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int peoples, line;
    private static List<List<Friends>> list;
    private static int[] visited;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        peoples = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        visited = new int[peoples];

        list = new ArrayList<>();
        for (int i = 0; i < peoples; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(new Friends(b));
            list.get(b).add(new Friends(a));
        }

        for (int i = 0; i < peoples; i++) {
            dfs(i, 0);
            if (flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int vertex, int depth) {
        if (visited[vertex] == 1) return;

        for (Friends f : list.get(vertex)) {
            if (flag) return;
            if (depth == 4) {
                flag = true;
                return;
            }
            visited[vertex] = 1;
            dfs(f.v, depth + 1);
            visited[vertex] = 0;
        }
    }
}

class Friends {
    int v;

    Friends(int v) {
        this.v = v;
    }
}