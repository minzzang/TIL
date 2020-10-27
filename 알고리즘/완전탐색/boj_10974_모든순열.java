 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-27
  * URL   : https://www.acmicpc.net/problem/10974
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] visited;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(i);
            dfs(depth+1);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}


