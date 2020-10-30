 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-30
  * URL   : https://www.acmicpc.net/problem/1182
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, S, count;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        powerSet(0);
        System.out.println(count);
    }

    private static void powerSet(int depth) {
        if (depth == N) {
            int sum = 0;
            boolean flag = false;
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    flag = true;
                    sum += arr[i];
                }
            }
            if (flag && sum == S) count++;
            return;
        }

        visited[depth] = false;
        powerSet(depth + 1);

        visited[depth] = true;
        powerSet(depth + 1);
    }
}