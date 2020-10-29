 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-29
  * URL   : https://www.acmicpc.net/problem/15651
  *
  */

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static char[] ch;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new char[M * 2];
        Arrays.fill(ch,' ');

        dfs(0);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            sb.append(ch).append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            ch[depth * 2] = (char)('0' + i + 1);
            dfs(depth+1);
        }
    }
}