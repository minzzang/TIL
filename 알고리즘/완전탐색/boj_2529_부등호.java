 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-06
  * URL   : https://www.acmicpc.net/problem/2529
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[] ch;
    private static boolean[] visited;
    private static int K;
    private static StringBuilder MIN, MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        ch = new char[K+1];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        dfs(0, new StringBuilder());
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int depth, StringBuilder sb) {
        if (depth == K+1) {
            if (MAX == null) {
                MIN = new StringBuilder(sb);
            }
            MAX = new StringBuilder(sb);
            return;
        }

        char sign = ch[depth];
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (sb.length() != 0) {
                int compareNumber = sb.charAt(sb.length()-1) - '0';
                if (sign == '>' && compareNumber <= i) continue;
                if (sign == '<' && compareNumber >= i) continue;
            }

            visited[i] = true;
            dfs(depth+1, sb.append(i));
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}